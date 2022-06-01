package com.softaai.bikestations.bikestation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softaai.bikestations.data.network.State
import com.softaai.bikestations.data.repository.BikeStationsRepository
import com.softaai.bikestations.model.BikeStationsApiResponse
import com.softaai.bikestations.model.Feature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BikeStationsViewModel @Inject constructor(private val bikeStationsRepository: BikeStationsRepository) :
    ViewModel() {

    private val _bikeStationsLiveData = MutableLiveData<State<BikeStationsApiResponse>>()

    val bikeStationsLiveData: LiveData<State<BikeStationsApiResponse>> = _bikeStationsLiveData

    private val _bikeStations = MutableLiveData(listOf<Feature>())
    val bikeStations: LiveData<List<Feature>> = _bikeStations

    fun getBikeStationsList() {
        viewModelScope.launch {
            bikeStationsRepository.getAllBikeStations()
                .onStart { _bikeStationsLiveData.value = State.loading() }
                .map { resource -> State.fromResource(resource) }
                .collect { state -> _bikeStationsLiveData.value = state }
        }
    }

    fun setHoldings(list: List<Feature>) {
        viewModelScope.launch {
            _bikeStations.value = list
        }
    }
}