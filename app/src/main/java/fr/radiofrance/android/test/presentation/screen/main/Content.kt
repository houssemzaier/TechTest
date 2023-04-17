package fr.radiofrance.android.test.presentation.screen.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.radiofrance.android.test.presentation.components.TopBar

val LocalTitle = compositionLocalOf<(String) -> Unit> { error("No Title was provided") }

@Composable
fun Content() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()


    val shouldShowUpButton = navBackStackEntry.isNotInStartDestination(navController)


    LaunchedEffect(shouldShowUpButton) {
        println("shouldShowUpButton changed: ${navBackStackEntry?.destination != null}")
    }

    var title by remember {
        mutableStateOf("")
    }
    val onTitleChange: (String) -> Unit = {
        title = it
    }

    CompositionLocalProvider(LocalTitle provides onTitleChange) {

        Scaffold(
            topBar = {
                TopBar(
                    shouldShowUpButton = shouldShowUpButton,
                    title = title,
                ) {
                    navController.navigateUp()
                }
            },
        ) {
            NavHostContent(navController, it)
        }
    }
}

private fun NavBackStackEntry?.isNotInStartDestination(
    navController: NavHostController,
): Boolean = this?.destination?.let { navDestination ->
    navDestination != navController.graph.findStartDestination()
} ?: false
