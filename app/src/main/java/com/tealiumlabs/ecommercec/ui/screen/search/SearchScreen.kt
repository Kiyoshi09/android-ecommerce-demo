package com.tealiumlabs.ecommercec.ui.screen.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenTopAppBar

@Composable
fun SearchScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            SearchScreenTopAppBar(
                navController = navController
            )
        },
        content = {
            SearchScreenContent()
        },
        bottomBar = {
            HomeScreenBottomBar(
                navController = navController
            )
        }
    )
}

@Composable
fun SearchScreenTopAppBar(
    navController: NavController,
) {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column (
            modifier = Modifier.weight(2f)
        ){
            Spacer(modifier = Modifier)
        }

        Column(
            modifier = Modifier.weight(6f),
        ) {
            Spacer(modifier = Modifier)
        }

        Column(
            modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.Cart.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = "Cart",
                    tint = MaterialTheme.colors.onSurface,
                )
            }
        }
    }
}

@Composable
fun SearchScreenContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = Screen.Search.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(16.dp)
        )

        Icon(imageVector = Screen.Search.icon, contentDescription = "Search", modifier = Modifier.fillMaxSize(0.3f))
    }
}