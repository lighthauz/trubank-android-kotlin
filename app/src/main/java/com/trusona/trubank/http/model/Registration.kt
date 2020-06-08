package com.trusona.trubank.http.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Registration(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("email_address")
    val email: String,
    @SerializedName("device_identifier")
    val deviceIdentifier: String,
    @SerializedName("is_completed")
    val isCompleted: Boolean? = false
)