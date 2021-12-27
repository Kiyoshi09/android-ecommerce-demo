package com.tealiumlabs.ecommercec.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tealiumlabs.ecommercec.ui.screen.product.ProductScreen
import com.tealiumlabs.ecommercec.ui.screen.cart.CartScreen
import com.tealiumlabs.ecommercec.ui.screen.checkout.CheckoutScreen
import com.tealiumlabs.ecommercec.ui.screen.checkout.CompleteScreen
import com.tealiumlabs.ecommercec.ui.screen.favorite.FavoriteScreen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreen
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.screen.other.OtherScreen
import com.tealiumlabs.ecommercec.ui.screen.search.SearchScreen
import com.tealiumlabs.ecommercec.ui.theme._veryLightGray

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun EcommNavigation(
    viewModel: EcommViewModel,
) {

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = _veryLightGray
        )
    }

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
            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(
            route = Screen.Search.route,
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
            SearchScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

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

        composable(
            route = Screen.Cart.route,
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
            CartScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

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

        ){
            ProductScreen(
                viewModel = viewModel,
                navController = navController,
                outfitId = it.arguments?.getLong("outfitId"),
            )
        }

        composable(
            route = Screen.Checkout.route,
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
            CheckoutScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }

        composable(
            route = Screen.Complete.route,
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
            CompleteScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }
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
){
    navController.navigate(Screen.Checkout.route) {
        launchSingleTop = true
        restoreState = true
    }
}