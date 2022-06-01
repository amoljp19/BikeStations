package com.softaai.bikestations.bikestation.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.softaai.bikestations.bikestation.ui.components.BikeStationsScreen
import com.softaai.bikestations.bikestation.ui.components.bikestationdetails.BikeStationDetailsScreen
import com.softaai.bikestations.bikestation.viewmodel.BikeStationsViewModel
import com.softaai.bikestations.model.Feature

@ExperimentalComposeUiApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    bikeStations: List<Feature>
) {

    NavHost(
        navController = navController,
        startDestination = Screen.BikeStationsScreen.route
    ) {
        composable(
            route = Screen.BikeStationsScreen.route
        ) {
            BikeStationsScreen(navController, bikeStations)
        }

        composable(
            route = Screen.BikeStationDetailsScreen.route
//             +
//                    "/{id}",
//            arguments = listOf(
//                navArgument(
//                    name = "id"
//                ) {
//                    type = NavType.StringType
//                }
//            )
        ) {
            BikeStationDetailsScreen(navController)
        }
    }

}