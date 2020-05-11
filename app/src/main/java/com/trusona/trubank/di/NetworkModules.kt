package com.trusona.trubank.di

import com.trusona.trubank.BuildConfig
import com.trusona.trubank.http.service.RegistrationService
import com.trusona.trubank.http.service.SessionService
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModules : BaseModuleProvider {
    private val SERVICE_URL = HttpUrl.parse("https://trubank.staging.trusona.net/")

    override val modules: List<Module>
        get() = listOf(
            registrationServiceModule,
            sessionServiceModule,
            retrofitModule
        )

    private val registrationServiceModule = module {
        single { get<Retrofit>().create(RegistrationService::class.java) }
    }

    private val sessionServiceModule = module {
        single { get<Retrofit>().create(SessionService::class.java) }
    }

    private val retrofitModule = module {
        single { provideOkHttpClient() }
        single { provideRetrofit(get(), SERVICE_URL) }
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
                HttpLoggingInterceptor.Level.NONE
        }

        //todo: verify if requireTLS12 is still needed for devices running api 21 and 22
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: HttpUrl?): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    private fun provideTrustManager(): X509TrustManager {
//        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
//        trustManagerFactory.init(null as KeyStore)
//       return trustManagerFactory.trustManagers[0] as X509TrustManager
//    }
}