package com.softaai.bikestations.data.network

import com.softaai.bikestations.model.BikeStationsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BikeStationsApiService {

    @GET("map_service.html?")
    suspend fun getBikeStationsApiResponse(
        @Query("mtype") mType: String,
        @Query("co") co: String
    )
            : Response<BikeStationsApiResponse>

}