package com.softaai.bikestations.bikestation.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.softaai.bikestations.bikestation.ui.components.BikeStationDetailsScreen
import com.softaai.bikestations.bikestation.ui.components.BikeStationsScreen

@ExperimentalComposeUiApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.BikeStationsScreen.route
    ) {
        composable(
            route = Screen.BikeStationsScreen.route
        ) {
            BikeStationsScreen()
        }

        composable(
            route = Screen.BikeStationDetailsScreen.route +
                    "?stationId={stationId}",
            arguments = listOf(
                navArgument(
                    name = "stationId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            BikeStationDetailsScreen()
        }
    }

}