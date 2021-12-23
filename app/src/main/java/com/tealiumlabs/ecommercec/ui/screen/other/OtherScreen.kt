package com.tealiumlabs.ecommercec.ui.screen.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.model.EcommViewModel

@Composable
fun OtherScreen(
    viewModel: EcommViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {

        },
        content = {
            OtherScreenContent()
        },
        bottomBar = {
            HomeScreenBottomBar(
                navController = navController
            )
        }
    )
}

@Composable
private fun OtherScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = Screen.Other.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(16.dp)
        )

        Icon(imageVector = Screen.Other.icon, contentDescription = "Other", modifier = Modifier.fillMaxSize(0.3f))
    }
}