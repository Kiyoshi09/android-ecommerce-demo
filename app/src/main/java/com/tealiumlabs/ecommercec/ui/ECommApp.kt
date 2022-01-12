package com.tealiumlabs.ecommercec.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.ui.navigation.EcommNavigation
import com.tealiumlabs.ecommercec.model.EcommViewModel

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun EcommApp(
    splashScreenVisibleCondition: (SplashScreen.KeepOnScreenCondition) -> Unit
) {

    splashScreenVisibleCondition {
        //loadComplete()
        false
    }

    val viewModel: EcommViewModel = viewModel()
    val navController: NavHostController = rememberNavController()

    EcommNavigation(
        navController = navController,
        viewModel = viewModel,
    )
}

//fun loadComplete(): Boolean {
//    return false
//}