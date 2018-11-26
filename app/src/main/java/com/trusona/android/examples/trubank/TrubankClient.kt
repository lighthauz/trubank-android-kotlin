package com.trusona.android.examples.trubank

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object TrubankClient {

    val service: TrubankService

    init {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://trubank.staging.trusona.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        service = retrofit.create<TrubankService>()
    }
}