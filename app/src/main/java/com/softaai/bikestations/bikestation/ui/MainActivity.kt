package com.softaai.bikestations.bikestation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.softaai.bikestations.bikestation.ui.nav.SetupNavGraph
import com.softaai.bikestations.bikestation.ui.theme.BikeStationsTheme
import com.softaai.bikestations.bikestation.viewmodel.BikeStationsViewModel
import com.softaai.bikestations.data.network.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mViewModel: BikeStationsViewModel by viewModels()
    lateinit var navController: NavHostController

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BikeStationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    getBikeStationsList()
                    navController = rememberNavController()

                    val bikeStations by mViewModel.bikeStations.observeAsState()
                    bikeStations?.let { SetupNavGraph(navController = navController, it) }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        observeBikeStationsLiveData()
    }

    private fun getBikeStationsList() = mViewModel.getBikeStationsList()

    private fun observeBikeStationsLiveData() {

        mViewModel.bikeStationsLiveData.observe(this) { state ->
            when (state) {
                is State.Loading -> Toast.makeText(
                    applicationContext,
                    "Loading...",
                    Toast.LENGTH_SHORT
                ).show()
                is State.Success -> {
                    Toast.makeText(
                        applicationContext,
                        " " + state.data.features,
                        Toast.LENGTH_SHORT
                    ).show()
                    mViewModel.setHoldings(state.data.features)
                }
                is State.Error -> {
                    Toast.makeText(applicationContext, " " + state.message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BikeStationsTheme {
        Greeting("Android")
    }
}