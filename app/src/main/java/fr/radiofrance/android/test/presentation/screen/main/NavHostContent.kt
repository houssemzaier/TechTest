package fr.radiofrance.android.test.presentation.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavHostContent(navController: NavHostController, paddingValues: PaddingValues) {
    val viewModel: MainViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "stations-screen",
    ) {

        composable("stations-screen") {
            StationsContentScreen(
                Modifier.padding(paddingValues),
                navController,
                viewModel,
            )
        }
        composable("shows-screen") {
            ShowsContentScreen(
                Modifier.padding(paddingValues),
                viewModel,
            )
        }
    }
}
