package com.trusona.trubank.http.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SessionRequest(
    @SerializedName("device_identifier")
    val deviceIdentifier: String
)