package com.softaai.bikestations.bikestation.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.softaai.bikestations.bikestation.ui.components.bikestations.BikeStationItem
import com.softaai.bikestations.bikestation.ui.nav.Screen
import com.softaai.bikestations.bikestation.viewmodel.BikeStationsViewModel
import com.softaai.bikestations.model.Feature

@Composable
fun BikeStationsScreen(
    navController: NavController,
    bikeStations: List<Feature>
) {

    val state = bikeStations

    LazyColumn(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        state.let {

            itemsIndexed(
                items = state,
                itemContent = { _, bikeStation ->
                    BikeStationItem(
                        bikeStation.properties,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate(
                                    route = Screen.BikeStationDetailsScreen.route //+
    //                                            "/${bikeStation.id}"
                                )
                            }
                    )
                }
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun BikeStationsScreenPreview() {
    BikeStationsScreen(navController = rememberNavController(), hiltViewModel())
}