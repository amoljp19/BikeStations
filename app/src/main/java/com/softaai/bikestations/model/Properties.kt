package com.softaai.bikestations.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Properties(
    @Json(name = "code")
    val code: String
)