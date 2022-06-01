package com.softaai.bikestations.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BikeStationsApiResponse(
    @Json(name = "crs")
    val crs: Crs,
    @Json(name = "features")
    val features: List<Feature>,
    @Json(name = "type")
    val type: String
)