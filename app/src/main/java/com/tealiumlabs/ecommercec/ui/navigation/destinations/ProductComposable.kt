package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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