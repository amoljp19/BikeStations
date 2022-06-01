package com.softaai.bikestations.bikestation.ui.components.bikestationdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.softaai.bikestations.model.Feature

@Composable
fun BikeStationDetailsScreen(
    navController: NavController,
    id: String?,
    bikeStations: List<Feature>
) {

    val bikeStation = bikeStations.get(id!!.toInt()).properties

    Box(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(16.dp)
        ) {

            val latlong = LatLng(
                bikeStations.get(id.toInt()).geometry.coordinates[0],
                bikeStations.get(id.toInt()).geometry.coordinates[1]
            ) 
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(latlong, 10f)
            }
            GoogleMap(
                modifier = Modifier.height(360.dp),
                cameraPositionState = cameraPositionState,
            ) {
                Marker(
                    state = MarkerState(position = latlong),
                    title = bikeStation.label,
                    snippet = "Marker in ${bikeStation.label}"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = bikeStation.label,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Available bikes : ${bikeStation.bikeRacks}",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Available places : ${bikeStation.freeRacks}",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun BikeStationsScreenPreview() {
    //BikeStationDetailsScreen(navController = rememberNavController())
}
