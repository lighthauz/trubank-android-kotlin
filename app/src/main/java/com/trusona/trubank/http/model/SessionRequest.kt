package com.trusona.trubank.http.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SessionRequest(
    val deviceIdentifier: String
)