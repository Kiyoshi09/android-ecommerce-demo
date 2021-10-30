package com.tealiumlabs.ecommercec.ui.screen.favorite

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
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenContent
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenTopAppBar
import com.tealiumlabs.ecommercec.ui.theme.ECommerceCTheme
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography

@Composable
fun FavoriteScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            FavoriteScreenTopAppBar(
                navController = navController
            )
        },
        content = {
           FavoriteScreenContent()
        },
        bottomBar = {
            HomeScreenBottomBar(
                navController = navController
            )
        }
    )
}

@Composable
fun FavoriteScreenTopAppBar(
    navController: NavController,
) {
    Row(
        Modifier.fillMaxWidth()
            .padding(0.dp, 10.dp, 10.dp, 0.dp),
        horizontalArrangement = Arrangement.End
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

@Composable
fun FavoriteScreenContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = Screen.Favorite.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(16.dp)
        )

        Icon(imageVector = Screen.Favorite.icon, contentDescription = "Favorite", modifier = Modifier.fillMaxSize(0.3f))
    }
}