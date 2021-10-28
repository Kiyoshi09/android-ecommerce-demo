package com.tealiumlabs.ecommercec.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tealiumlabs.ecommercec.ui.theme.ECommerceCTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var splashScreen: SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashScreen = installSplashScreen()

        setContent {
            AppContent{
                splashScreen.setKeepVisibleCondition(it)
            }
        }
    }

    @Composable
    fun AppContent(splashScreenVisibleCondition: (SplashScreen.KeepOnScreenCondition) -> Unit) {
        ECommerceCTheme {
            Surface {
                EcommApp(splashScreenVisibleCondition)
            }
        }
    }
}