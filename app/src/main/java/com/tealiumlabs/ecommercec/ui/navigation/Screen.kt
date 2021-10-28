package com.tealiumlabs.ecommercec.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(open val route: String = "", open val icon: ImageVector, open val title: String) {
    object Home : Screen("home", Icons.Outlined.Home, "Home")
    object Favorite: Screen("favorite", Icons.Outlined.Favorite, "Favorite")
    object Search: Screen("search", Icons.Outlined.Search, "Search")
    object History: Screen("history", Icons.Outlined.Receipt, "History")
    object Profile: Screen("profile", Icons.Outlined.Person, "Profile")
}