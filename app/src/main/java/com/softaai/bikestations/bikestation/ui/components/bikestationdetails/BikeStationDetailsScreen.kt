package com.softaai.bikestations.bikestation.ui.components.bikestationdetails

import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.softaai.bikestations.bikestation.ui.nav.Screen

@Composable
fun BikeStationDetailsScreen(
    navController: NavController
) {

    /* Box(
     modifier = modifier
     ) {
         Column(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(16.dp)
                 .padding(end = 32.dp)
         ) {
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
     }*/
}

@Composable
fun Greeting(name: String) {
    androidx.compose.material3.Text(text = "Hello $name!")
}

@Preview(showSystemUi = true)
@Composable
fun BikeStationsScreenPreview() {
    BikeStationDetailsScreen(navController = rememberNavController())
}
