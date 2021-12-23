package com.tealiumlabs.ecommercec.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(open val route: String = "",
                    open val icon: ImageVector,
                    open val title: String) {

    object Home : Screen("home", Icons.Outlined.Home, "Home")
    object Search: Screen("search", Icons.Outlined.Search, "Search")
    object Favorite: Screen("favorite", Icons.Outlined.Favorite, "Favorite")
    object Other: Screen("other", Icons.Outlined.Menu, "Other")
    object Cart: Screen("cart", Icons.Outlined.ShoppingCart, "Cart")
    object Product: Screen("product", Icons.Outlined.Android, "Product")
    object Checkout: Screen("Checkout", Icons.Outlined.Android, "Checkout")
    object Complete: Screen("Complete", Icons.Outlined.Android, "Complete")

    companion object {
        fun getBottomTabScreens(): List<Screen> {
            return listOf(Home, Search, Favorite, Other)
        }
    }
}

