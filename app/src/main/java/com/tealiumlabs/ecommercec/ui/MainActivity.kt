package com.tealiumlabs.ecommercec.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.tealiumlabs.ecommercec.ui.theme.ECommerceCTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var splashScreen: SplashScreen

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashScreen = installSplashScreen()

        setContent {
            AppContent {
                splashScreen.setKeepVisibleCondition(it)
            }
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun AppContent(
        splashScreenVisibleCondition: (SplashScreen.KeepOnScreenCondition) -> Unit
    ) {
        ECommerceCTheme {
            Surface {
                EcommApp(
                    splashScreenVisibleCondition = splashScreenVisibleCondition
                )
            }
        }
    }
}