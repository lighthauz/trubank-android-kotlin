package com.trusona.trubank.http.model

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Registration(
    val id: UUID,
    val email: String,
    val deviceIdentifier: String,
    val isCompleted: Boolean
)