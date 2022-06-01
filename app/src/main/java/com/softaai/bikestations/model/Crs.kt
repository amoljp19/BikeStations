package com.softaai.bikestations.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Crs(
    @Json(name = "properties")
    val properties: Properties,
    @Json(name = "type")
    val type: String
)