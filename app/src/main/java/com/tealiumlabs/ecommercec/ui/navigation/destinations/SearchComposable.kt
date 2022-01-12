package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.search.SearchScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.searchComposable(
    viewModel: EcommViewModel,
    navController: NavController,
){
    composable(
        route = Screen.Search.route,
    ){
        SearchScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}