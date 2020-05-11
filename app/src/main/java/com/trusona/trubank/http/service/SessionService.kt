package com.trusona.trubank.http.service

import com.trusona.trubank.http.model.SessionRequest
import com.trusona.trubank.http.model.SessionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SessionService {
    @POST("api/v1/sessions")
    suspend fun create(@Body request: SessionRequest): Response<SessionResponse>
}
