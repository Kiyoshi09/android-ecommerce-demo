package com.tealiumlabs.ecommercec.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.ui.navigation.EcommNavigation
import com.tealiumlabs.ecommercec.model.EcommViewModel

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun EcommApp(splashScreenVisibleCondition: (SplashScreen.KeepOnScreenCondition) -> Unit) {

    val viewModel: EcommViewModel = viewModel()
    splashScreenVisibleCondition {
        loadComplete()
    }

    EcommNavigation(viewModel)
}

fun loadComplete(): Boolean {
    return false
}