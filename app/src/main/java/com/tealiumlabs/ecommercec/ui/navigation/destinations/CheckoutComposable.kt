package com.tealiumlabs.ecommercec.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.checkout.CheckoutScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.checkoutComposable(
    viewModel: EcommViewModel,
    navController: NavController,
){
    composable(
        route = Screen.Checkout.route,
    ){
        CheckoutScreen(
            viewModel = viewModel,
            navController = navController,
        )
    }
}