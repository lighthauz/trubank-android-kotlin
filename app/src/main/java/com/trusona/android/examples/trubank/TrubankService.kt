package com.trusona.android.examples.trubank

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TrubankService {

    @POST("registrations")
    fun register(@Body registrationRequest: RegistrationRequest): Call<RegistrationResponse>

    @GET("registrations/{registration_identifier}")
    fun getRegistration(@Path("registration_identifier") registrationIdentifier: String): Call<RegistrationResponse>
}