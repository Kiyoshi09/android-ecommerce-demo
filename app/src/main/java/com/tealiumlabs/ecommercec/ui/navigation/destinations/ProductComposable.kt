package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.google.accompanist.navigation.animation.composable
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.product.ProductScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.productComposable(
    viewModel: EcommViewModel,
    navController: NavController,
){
    composable(
        route = "${Screen.Product.route}/{outfitId}",
        enterTransition = {initial, _ ->
            null
        },
        exitTransition = { _, target ->
            null
        },
        popEnterTransition = { initial, _ ->
            null
        },
        arguments = listOf(
            navArgument("outfitId") {
                type = NavType.LongType
            }
        )

    ){ navBackStackEntry ->
        ProductScreen(
            viewModel = viewModel,
            navController = navController,
            outfitId = navBackStackEntry.arguments?.getLong("outfitId"),
        )
    }
}