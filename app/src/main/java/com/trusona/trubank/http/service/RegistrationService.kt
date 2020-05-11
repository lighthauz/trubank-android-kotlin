package com.trusona.trubank.http.service

import com.trusona.trubank.http.model.Registration
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RegistrationService {
    @POST("api/v1/registrations")
    suspend fun create(): Response<Registration>

    @GET("api/v1/registrations/{registration_identifier}")
    suspend fun get(@Path("registration_identifier") registrationIdentifier: String): Response<Registration>
}