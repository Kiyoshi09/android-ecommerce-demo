package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.favorite.FavoriteScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.favoriteComposable(
    viewModel: EcommViewModel,
    navController: NavController,
){
    composable(
        route = Screen.Favorite.route,
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
        FavoriteScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}