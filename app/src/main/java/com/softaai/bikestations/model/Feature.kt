package com.softaai.bikestations.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Feature(
    @Json(name = "geometry")
    val geometry: Geometry,
    @Json(name = "id")
    val id: String,
    @Json(name = "properties")
    val properties: PropertiesX,
    @Json(name = "type")
    val type: String
)