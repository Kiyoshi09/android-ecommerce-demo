package com.tealiumlabs.ecommercec.ui.screen.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography
import com.tealiumlabs.ecommercec.ui.theme.Ocean8
import com.tealiumlabs.ecommercec.ui.theme.veryLighGray

@Composable
fun CompleteScreen(
    viewModel: EcommViewModel,
    navController: NavController
) {
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
                    text = "YOUR ORDER HAS BEEN RECEIVED",
                    style = EcommTypography.subtitle1.copy(fontSize = 20.sp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                   text = "THANK YOU FOR YOUR PURCHASE!",
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
            HomeScreenBottomBar(
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
                text = "Tealium Commerce",
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