package com.softaai.bikestations.di.module

import com.softaai.bikestations.data.repository.BikeStationsRepository
import com.softaai.bikestations.data.repository.DefaultBikeStationsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class BikeStationRepositoryModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindBikeStationsRepository(bikeStationsRepository: DefaultBikeStationsRepository): BikeStationsRepository

}