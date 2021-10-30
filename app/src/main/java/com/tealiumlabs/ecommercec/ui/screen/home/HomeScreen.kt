package com.tealiumlabs.ecommercec.ui.screen.home

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.theme.ECommerceCTheme
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography

@Composable
fun HomeScreen(
    vieModel: ViewModel,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            HomeScreenTopAppBar(
                navController = navController
            )
        },
        content = {
            HomeScreenContent()
        },
        bottomBar = {
            HomeScreenBottomBar(
                navController = navController
            )
        }
    )
}

@Composable
fun HomeScreenTopAppBar(
    navController: NavController,
) {
    Row(
        Modifier.fillMaxWidth()
            .padding(0.dp, 10.dp, 10.dp, 0.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "Tealium Commerce",
            Modifier.padding(0.dp, 10.dp, 60.dp, 0.dp),
            style = EcommTypography.h6
        )

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

//    Column {
//        TopAppBar(
//            title = {
//                Text(
//                    "Tealium Commerce",
//                    Modifier.padding(100.dp, 0.dp, 0.dp, 0.dp),
//                    style = EcommTypography.h6
//                )
//            },
//            backgroundColor = MaterialTheme.colors.surface,
//            elevation = 0.dp,
//            actions = {
//                IconButton(onClick = {
//                    navController.navigate(Screen.Cart.route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_cart),
//                        contentDescription = "Cart",
//                        tint = MaterialTheme.colors.onSurface
//                    )
//                }
//            }
//        )
//    }
}


@Composable
fun HomeScreenContent() {

    Column {

        //GlobalSearch()

        CategoryTabs()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GlobalSearch() {
    var qry by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = qry,
                onValueChange = { qry = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 8.dp),
                shape = RoundedCornerShape(20.dp),
                label = {
                    Text(text = "Search")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                   onSearch = {
                       Log.i("Kiyoshi","Search : ${qry}")

                       keyboardController?.hide()
                   }
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                        tint = MaterialTheme.colors.onSurface
                    )
                },
                singleLine = true,
            )
        }
    }
}

@Composable
fun CategoryTabs() {

    val categoryList = listOf("ALL", "WOMEN", "MEN", "ACCESSORIES", "HOME & DECOR", "SALE", "VIP")
    var selectedIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 16.dp,
        backgroundColor = MaterialTheme.colors.background,
        divider = {},
        indicator = {}
    ) {
        categoryList.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { selectedIndex = index }
            )
            {
                CategoryChip(
                    categoryName = category,
                    selected = index == selectedIndex,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp)
                )
            }

        }
    }
}

@Composable
fun CategoryChip(
    categoryName: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> MaterialTheme.colors.primary
            else -> MaterialTheme.colors.onBackground.copy(alpha = 0.12f)
        },
        contentColor = when {
            selected -> MaterialTheme.colors.onPrimary
            else -> MaterialTheme.colors.onBackground
        },
        shape = RoundedCornerShape(40),
        modifier = modifier
    ) {
        Text(
            text = categoryName,
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun HomeScreenBottomBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    BottomNavigation {
        Screen.getBottomTabScreens().forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(screen.icon, screen.title) },
                label = { Text(screen.title) }
            )
        }
    }
}


//private fun setTheme(darkTheme: Boolean) {
//    if (darkTheme) {
//        setLightTheme()
//    } else
//        setDarkTheme()
//}
//
//private fun setLightTheme() {
//    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//}
//
//private fun setDarkTheme() {
//    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//}