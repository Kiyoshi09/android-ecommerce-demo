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
import com.tealiumlabs.ecommercec.ui.navigation.EcommNavigation
import com.tealiumlabs.ecommercec.ui.screen.home.HomeViewModel

@ExperimentalAnimationApi
@Composable
fun EcommApp(splashScreenVisibleCondition: (SplashScreen.KeepOnScreenCondition) -> Unit) {

    val context = LocalContext.current
    var isOnline by remember { mutableStateOf(checkIfOnline(context)) }

    if (isOnline) {
        val viewModel: HomeViewModel = viewModel()
        splashScreenVisibleCondition {
            //viewModel.state.value.run {
            //    petState.loading || specialNeedsDogState.loading
            //}
            dummy1()
        }
        EcommNavigation(viewModel)
    } else {
        OfflineDialog { isOnline = checkIfOnline(context) }
    }

}

// dummy function
fun dummy1(): Boolean {
   return false
}


@Composable
fun OfflineDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "No Internet") },
        text = { Text(text = "No internet connection. Turn on Wifi or mobile data.") },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text("Retry")
            }
        }
    )
}

@Suppress("DEPRECATION")
private fun checkIfOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}