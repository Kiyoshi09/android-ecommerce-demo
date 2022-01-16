package com.tealiumlabs.ecommercec.ui.screen.checkout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.tealium.TealiumHelperList
import com.tealiumlabs.ecommercec.ui.components.ScreenBottomBar
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography
import com.tealiumlabs.ecommercec.ui.theme.Ocean8
import com.tealiumlabs.ecommercec.ui.theme.veryLighGray

@Composable
fun CompleteScreen(
    viewModel: EcommViewModel,
    navController: NavController
) {
    /////////// TEALIUM TRACKING /////////////
    LaunchedEffect(key1 = TealiumHelperList.currentInstanceName){
        TealiumHelperList.currentTealiumHelper?.let { tealiumHelper ->

            Log.d("KIYOSHI-TEALIUM-TRACKING", "complete")

            tealiumHelper.trackView(
                instanceName = TealiumHelperList.currentInstanceName!!,
                name = "screen_view",
                data = mutableMapOf(
                    "screen_name" to "complete",
                    "screen_type" to "complete",
                )
            )
        }
    }
    //////////////////////////////////////////

    Scaffold(
        topBar = {
            CompleteScreenTopAppBar()
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.order_received),
                    style = EcommTypography.subtitle1.copy(fontSize = 20.sp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                   text = stringResource(id = R.string.thank_you),
                   style = EcommTypography.body1.copy(fontSize = 20.sp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Icon(
                    imageVector = Icons.Filled.TaskAlt,
                    contentDescription = null,
                    tint = Ocean8,
                    modifier = Modifier.size(256.dp)
                )
            }
        },
        bottomBar = {
            ScreenBottomBar(
                navController = navController
            )
        }
    )

}

@Composable
private fun CompleteScreenTopAppBar(
) {
    Row(
        Modifier
            .background(veryLighGray)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.weight(2f)
        ) {
            Spacer(modifier = Modifier)
        }

        Column(
            modifier = Modifier.weight(7f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.tealium_ecommerce),
                Modifier.padding(20.dp, 8.dp, 0.dp, 0.dp),
                style = EcommTypography.subtitle1.copy(
                    fontSize = 18.sp
                )
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
        }

        Column(
            modifier = Modifier.weight(1.5f),
            horizontalAlignment = Alignment.Start
        )
        {
        }
    }
}