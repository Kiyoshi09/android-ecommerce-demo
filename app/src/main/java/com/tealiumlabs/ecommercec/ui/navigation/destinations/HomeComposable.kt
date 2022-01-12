package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreen

@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.homeComposable(
    viewModel: EcommViewModel,
    navController: NavController,
) {
    composable(
        route = Screen.Home.route,
    ){
        HomeScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}