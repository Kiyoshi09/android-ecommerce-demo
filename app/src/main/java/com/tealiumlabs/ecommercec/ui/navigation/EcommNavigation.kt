package com.tealiumlabs.ecommercec.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.navigation.destinations.*
import com.tealiumlabs.ecommercec.ui.theme._veryLightGray

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun EcommNavigation(
    navController: NavHostController,
    viewModel: EcommViewModel,
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = _veryLightGray
        )
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        homeComposable(
            viewModel = viewModel,
            navController = navController,
        )

        searchComposable(
            viewModel = viewModel,
            navController = navController,
        )

        favoriteComposable(
            viewModel = viewModel,
            navController = navController,
        )

        otherComposable(
            viewModel = viewModel,
            navController = navController,
        )

        cartComposable(
            viewModel = viewModel,
            navController = navController,
        )

        productComposable(
            viewModel = viewModel,
            navController = navController,
        )

        checkoutComposable(
            viewModel = viewModel,
            navController = navController,
        )

        completeComposable(
            viewModel = viewModel,
            navController = navController,
        )
    }
}


fun moveToProductScreen(
    navController: NavController,
    prodId: Long,
) {
    navController.navigate("${Screen.Product.route}/$prodId") {
        launchSingleTop = true
        restoreState = true
    }
}

fun moveToCheckoutScreen(
    navController: NavController,
) {
    navController.navigate(Screen.Checkout.route) {
        launchSingleTop = true
        restoreState = true
    }
}