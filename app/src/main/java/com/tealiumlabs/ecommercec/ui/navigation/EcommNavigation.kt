package com.tealiumlabs.ecommercec.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tealiumlabs.ecommercec.ui.screen.cart.CartScreen
import com.tealiumlabs.ecommercec.ui.screen.favorite.FavoriteScreen
import com.tealiumlabs.ecommercec.ui.screen.history.HistoryScreen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeViewModel
import com.tealiumlabs.ecommercec.ui.screen.profile.ProfileScreen
import com.tealiumlabs.ecommercec.ui.screen.search.SearchScreen

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
            HomeScreen(viewModel = viewModel, navController = navController)
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
            FavoriteScreen(navController = navController)
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
            SearchScreen(navController = navController)
        }

        composable(
            route = Screen.History.route,
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
            HistoryScreen(navController = navController)
        }

        composable(
            route = Screen.Profile.route,
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
            ProfileScreen(navController = navController)
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
            CartScreen(navController = navController)
        }
    }

}