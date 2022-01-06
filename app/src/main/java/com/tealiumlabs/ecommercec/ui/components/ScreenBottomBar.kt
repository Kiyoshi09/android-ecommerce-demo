package com.tealiumlabs.ecommercec.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tealiumlabs.ecommercec.ui.navigation.Screen

@Composable
fun ScreenBottomBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    BottomNavigation {
        Screen.getBottomTabScreens().forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    val sameItemClicked =
                        currentDestination?.hierarchy?.any { it.route == screen.route } == true

                    if (!sameItemClicked) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                },
                icon = { Icon(screen.icon, screen.title) },
                label = { Text(screen.title) }
            )
        }
    }
}