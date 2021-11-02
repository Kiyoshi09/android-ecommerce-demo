package com.tealiumlabs.ecommercec.ui.screen.home

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.data.repositories.SweetsCategory
import com.tealiumlabs.ecommercec.model.SweetsAd
import com.tealiumlabs.ecommercec.ui.components.ECommcSurface
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.theme.ECommerceCTheme
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            HomeScreenTopAppBar(
                navController = navController
            )
        },
        content = {
            HomeScreenContent(viewModel = viewModel)
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
        Modifier
            .fillMaxWidth()
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
                tint = colors.onSurface,
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
fun HomeScreenContent(viewModel: HomeViewModel) {

    Column {

        //GlobalSearch()

        CategoryTabs()

        BodyContents(viewModel = viewModel)
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
                        Log.i("Kiyoshi", "Search : ${qry}")

                        keyboardController?.hide()
                    }
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                        tint = colors.onSurface
                    )
                },
                singleLine = true,
            )
        }
    }
}

@Composable
fun CategoryTabs() {

    var selectedIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 16.dp,
        backgroundColor = colors.background,
        divider = {},
        indicator = {}
    ) {
        SweetsCategory.getSweetsCategoryList().forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { selectedIndex = index }
            )
            {
                CategoryChip(
                    categoryName = category.title,
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
    ECommerceCTheme {
        Surface(
            color = when {
                selected -> colors.primary
                else -> colors.onBackground.copy(alpha = 0.12f)
            },
            contentColor = when {
                selected -> colors.onPrimary
                else -> colors.onBackground
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

@OptIn(ExperimentalCoilApi::class)
@Composable
fun BodyContents(viewModel: HomeViewModel) {

    Box {
        LazyColumn {
            item {

//                LazyRow {
//                    itemsIndexed(viewModel.sweetsAdList) { index, sweetsAd ->
//                        val painter = rememberImagePainter(
//                            data = sweetsAd.imageUrl,
//                            builder = {
//                                crossfade(true)
//                                placeholder(drawableResId = R.drawable.plate_placeholder)
//                            },
//                        )
//
//                        Image(
//                            painter = painter,
//                            contentDescription = sweetsAd.name,
//                            modifier = Modifier.size(280.dp),
//                            contentScale = ContentScale.Crop
//                        )
//                    }
//                }

                LazyRow {
                    itemsIndexed(viewModel.sweetsAdList) { index, sweetsAd ->
                        SweetsAdItem(
                            sweetsAd = sweetsAd
                        )
                        { sweetsCategory ->
                            Log.i("Kiyoshi","Carousel Ad Category : ${sweetsCategory}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SweetsAdItem(
    sweetsAd: SweetsAd,
    modifier: Modifier = Modifier,
    onSweetsAdClick: (SweetsCategory) -> Unit
){
    ECommcSurface (
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(
            start = 4.dp,
            end = 4.dp,
            bottom = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { }
                .padding(8.dp)
        ) {
            SweetsAdImage(
                imageUrl = sweetsAd.imageUrl,
                elevation = 4.dp,
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )
//            Text(
//                text = sweetsAd.name,
//                style = MaterialTheme.typography.subtitle1,
//                color = MaterialTheme.colors.secondary
//            )
        }
    }
}

@Composable
private fun SweetsAdImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
) {
    ECommcSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                    placeholder(drawableResId = R.drawable.plate_placeholder)
                }
            ),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
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