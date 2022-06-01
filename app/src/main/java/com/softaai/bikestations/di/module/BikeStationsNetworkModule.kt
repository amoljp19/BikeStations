package com.softaai.bikestations.di.module

import com.softaai.bikestations.data.network.BikeStationsApiService
import com.softaai.bikestations.data.network.RequestInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class BikeStationsNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().addInterceptor(RequestInterceptor()).build()


    @Singleton
    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): BikeStationsApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .client(okHttpClient)
        .build()
        .create(BikeStationsApiService::class.java)

    companion object {
        const val BASE_URL: String = "http://www.poznan.pl/mim/plan/"    //use https instead of http to avoid cleartext error
    }
}