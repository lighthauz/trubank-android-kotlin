package com.trusona.trubank.http.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SessionResponse(
    @SerializedName("id")
    val id: String
)