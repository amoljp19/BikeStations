package com.softaai.bikestations.data.repository

import com.softaai.bikestations.data.network.BikeStationsApiService
import com.softaai.bikestations.data.network.Resource
import com.softaai.bikestations.model.BikeStationsApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response
import javax.inject.Inject

interface BikeStationsRepository {
    fun getAllBikeStations(mType: String, co: String): Flow<Resource<BikeStationsApiResponse>>
}

class DefaultBikeStationsRepository @Inject constructor(
    private val bikeStationsApiService: BikeStationsApiService
) : BikeStationsRepository {

    override fun getAllBikeStations(
        mType: String,
        co: String
    ): Flow<Resource<BikeStationsApiResponse>> {
        return object :
            NetworkBoundRepository<BikeStationsApiResponse, BikeStationsApiResponse>() {

            override suspend fun emitFromRemote(): Flow<BikeStationsApiResponse> =
                flowOf(fetchFromRemote().body()!!)

            override suspend fun fetchFromRemote(): Response<BikeStationsApiResponse> =
                bikeStationsApiService.getBikeStationsApiResponse(mType, co)

        }.asFlow()
    }
}