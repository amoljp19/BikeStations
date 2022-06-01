package com.softaai.bikestations.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PropertiesX(
    @Json(name = "bike_racks")
    val bikeRacks: String,
    @Json(name = "bikes")
    val bikes: String,
    @Json(name = "free_racks")
    val freeRacks: String,
    @Json(name = "label")
    val label: String,
    @Json(name = "updated")
    val updated: String
)