package com.tealiumlabs.ecommercec.ui

import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.ui.navigation.EcommNavigation
import com.tealiumlabs.ecommercec.ui.screen.home.HomeViewModel

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun EcommApp(splashScreenVisibleCondition: (SplashScreen.KeepOnScreenCondition) -> Unit) {

    val viewModel: HomeViewModel = viewModel()
    splashScreenVisibleCondition {
        loadComplete()
    }

    EcommNavigation(viewModel)
}

fun loadComplete(): Boolean {
    return false
}