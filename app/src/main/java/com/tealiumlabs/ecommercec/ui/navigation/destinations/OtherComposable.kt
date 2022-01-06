package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.other.OtherScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.otherComposable(
    viewModel: EcommViewModel,
    navController: NavController,
){
    composable(
        route = Screen.Other.route,
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
        OtherScreen(
            viewModel = viewModel,
            navController = navController,
        )
    }
}