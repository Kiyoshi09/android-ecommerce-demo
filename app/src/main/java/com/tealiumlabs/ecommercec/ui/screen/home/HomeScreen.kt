package com.tealiumlabs.ecommercec.ui.screen.home

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.*
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.search.SearchBar
import com.tealiumlabs.ecommercec.ui.screen.search.SearchDisplay
import com.tealiumlabs.ecommercec.ui.screen.search.SearchState
import com.tealiumlabs.ecommercec.ui.screen.search.rememberSearchState
import com.tealiumlabs.ecommercec.ui.theme.*
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController,
    state: SearchState<Outfit> = rememberSearchState()
) {
    val selectedTabIndex: Int by viewModel.selectedTabIndex.observeAsState(initial = OutfitCategory.All.index)

    Scaffold(
        topBar = {
            HomeScreenTopAppBar(
                navController = navController
            )
        },
        content = {
            HomeScreenBody(
                outfitAdList = viewModel.outfitAdList,
                outfitCampaignList = viewModel.outfitCampaignList,
                outfitNewProductList = viewModel.outfitNewProductList,
                outfitWomenList = viewModel.outfitWomenList,
                outfitMenList = viewModel.outfitMenList,
                outfitSearchResultList = viewModel.getSearchResults(state.query.text),
                state = state,
                selectedTabIndex = selectedTabIndex,
            ){
                viewModel.onChangeSelectedTab(it)
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
fun HomeScreenTopAppBar(
    navController: NavController,
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
            modifier = Modifier.weight(6f),
        ) {
            Text(
                text = "Tealium Commerce",
                Modifier.padding(24.dp, 8.dp, 0.dp, 0.dp),
                style = EcommTypography.subtitle1
            )
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
                    tint = colors.onSurface,
                )
            }
        }
    }
}


@ExperimentalPagerApi
@Composable
fun HomeScreenBody(
    outfitAdList: List<OutfitAd>,
    outfitCampaignList: List<OutfitCampaign>,
    outfitNewProductList: List<Outfit>,
    outfitWomenList: List<Outfit>,
    outfitMenList: List<Outfit>,
    outfitSearchResultList: List<Outfit>,
    state: SearchState<Outfit>,
    selectedTabIndex: Int,
    onChangeSelectedTab: (Int) -> Unit
) {

    Column {
        // Search Bar
        GlobalSearch(state)

        // Category Tabs
        CategoryTabs(
            state = state,
            selectedIndex = selectedTabIndex,
            onSelectedIndexChange = onChangeSelectedTab
        )

        LaunchedEffect(key1 = state.query){
            Log.i("Kiyoshi", "Launched Effect : ${state.query.text}")

            delay(100)
            state.searchResults = outfitSearchResultList
            state.searching = false
        }

        // Main Content
        when (state.searchDisplay) {
            SearchDisplay.InitialResults -> {
                Log.i("Kiyoshi", "Search Display InitialResults")

                when (selectedTabIndex) {
                    OutfitCategory.All.index -> {

                        HomeScreenContentAll(
                            outfitAdList = outfitAdList,
                            outfitCampaignList = outfitCampaignList,
                            outfitNewProductList = outfitNewProductList,
                        )
                    }

                    OutfitCategory.Women.index -> {
                        HomeScreenContentList(
                            outfitList = outfitWomenList,
                        )
                    }

                    OutfitCategory.Men.index -> {
                        HomeScreenContentList(
                            outfitList = outfitMenList,
                        )
                    }

                    OutfitCategory.Accessories.index -> {

                    }

                    OutfitCategory.HomeDecor.index -> {

                    }

                    OutfitCategory.Sale.index -> {

                    }
                }
            }

            SearchDisplay.NoResults -> {
                Log.i("Kiyoshi", "Search Display NoResults")

            }

            SearchDisplay.Results -> {
                Log.i("Kiyoshi", "Search Display Results")

                HomeScreenContentList(
                    outfitList = outfitSearchResultList
                )
            }
        }
    }
}

@Composable
fun GlobalSearch(
    state: SearchState<Outfit>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(veryLighGray)
    ) {
        SearchBar(
            query = state.query,
            onQueryChange = { state.query = it },
            onSearchFocusChange = { state.focused = it },
            onClearQuery = { state.query = TextFieldValue("") },
            onBack = { state.query = TextFieldValue("") },
            searching = state.searching,
            focused = state.focused,
            modifier = Modifier
        )
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CategoryTabs(
    state: SearchState<Outfit>,
    selectedIndex: Int,
    onSelectedIndexChange: (Int) -> Unit
) {
    when (state.searchDisplay) {
        SearchDisplay.InitialResults -> {

            ScrollableTabRow(
                edgePadding = 8.dp,
                selectedTabIndex = selectedIndex,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[selectedIndex])
                    )
                },
                backgroundColor = veryLighGray
            ) {
                OutfitCategory.getOutfitCategoryList().forEachIndexed { index, category ->
                    Tab(
                        selected = selectedIndex == index,
                        onClick = { onSelectedIndexChange(index) },
                    ){
                        Surface(
                            modifier = Modifier
                                .padding(top = 0.dp, bottom = 4.dp),
                        ) {
                            Text(
                                text = category.title,
                                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium),
                                modifier = Modifier
                                    .background(veryLighGray)
                                    .padding(horizontal = 16.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

        }
        SearchDisplay.NoResults -> {

        }
        SearchDisplay.Results -> {

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
