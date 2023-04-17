package fr.radiofrance.android.test.presentation.screen.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import fr.radiofrance.android.test.presentation.components.ShowListContent
import fr.radiofrance.android.test.presentation.components.StationListContent
import fr.radiofrance.android.test.presentation.util.ComposableOnState


@Composable
fun StationsContentScreen(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    LocalTitle.current("Nos stations")

    val stationList by viewModel.brandList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getStation()
    }

    ComposableOnState(state = stationList, modifier = modifier) {
        StationListContent(it, modifier) { station ->
            viewModel.setCurrentStation(station)
            navController.navigate("shows-screen")
        }
    }
}

@Composable
fun ShowsContentScreen(
    modifier: Modifier,
    viewModel: MainViewModel,
) {
    LocalTitle.current("Les émissions")

    val currentStation by viewModel.currentStation.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        val state = currentStation
        Log.d("LaunchedEffect current", currentStation.toString())

        if (state != null) viewModel.getShows(state)
    }

    val showList by viewModel.showList.collectAsStateWithLifecycle()

    ComposableOnState(showList, modifier) {
        ShowListContent(showList = it, modifier)
    }
}

