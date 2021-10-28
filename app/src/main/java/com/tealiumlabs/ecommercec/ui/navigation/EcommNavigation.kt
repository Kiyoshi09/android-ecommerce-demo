package com.tealiumlabs.ecommercec.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeViewModel

@ExperimentalAnimationApi
@Composable
fun EcommNavigation(viewModel: HomeViewModel) {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(
            route = Screen.Home.route,
            enterTransition = {initial, _ ->
                null
            },
            exitTransition = { _, target ->
                null
            },
            popEnterTransition = { initial, _ ->
                null
            }
        ){
            HomeScreen(vieModel = viewModel, navController = navController)
        }
    }

}