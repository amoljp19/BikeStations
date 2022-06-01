package com.softaai.bikestations.bikestation.ui.nav

sealed class Screen(val route: String) {
    object BikeStationsScreen : Screen("bike_stations_screen")
    object BikeStationDetailsScreen : Screen("bike_station_details_screen")
}
