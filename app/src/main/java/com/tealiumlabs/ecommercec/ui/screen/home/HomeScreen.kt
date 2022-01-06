package com.tealiumlabs.ecommercec.ui.screen.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.data.prefsStore.readTealiumAccountSettings
import com.tealiumlabs.ecommercec.model.*
import com.tealiumlabs.ecommercec.ui.components.GlobalTopAppBar
import com.tealiumlabs.ecommercec.ui.components.ScreenBottomBar
import com.tealiumlabs.ecommercec.ui.screen.search.GlobalSearch
import com.tealiumlabs.ecommercec.ui.screen.search.SearchDisplay
import com.tealiumlabs.ecommercec.ui.screen.search.SearchState
import com.tealiumlabs.ecommercec.ui.screen.search.rememberSearchState
import com.tealiumlabs.ecommercec.ui.theme.*
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    viewModel: EcommViewModel,
    navController: NavController,
    state: SearchState<Outfit> = rememberSearchState()
) {
    //val selectedTabIndex: Int by viewModel.selectedTabIndex.observeAsState(initial = OutfitCategory.All.index)
    val selectedTabIndex: Int = viewModel.selectedTabIndex.value

    val tealConfigStr = readTealiumAccountSettings(LocalContext.current).collectAsState(initial = ";;;").value
    val acct = tealConfigStr.split(";")[0]
    val prof = tealConfigStr.split(";")[1]
    val ds = tealConfigStr.split(";")[2]
    val env = tealConfigStr.split(";")[3]

    viewModel.tealiumAccount.value = acct
    viewModel.tealiumProfile.value = prof
    viewModel.tealiumDataSource.value = ds
    viewModel.tealiumEnvironment.value = env

//    Log.d("KIYOSHI-TEAL", "[tealium settings] " +
//            "account:${viewModel.tealiumAccount.value}, " +
//            "profile:${viewModel.tealiumProfile.value}, " +
//            "dataSource:${viewModel.tealiumDataSource.value}, " +
//            "environment:${viewModel.tealiumEnvironment.value}"
//    )

    Scaffold(
        topBar = {
            GlobalTopAppBar(
                navController = navController,
                outfitsInCart = viewModel.cartAddedItemsTotalQty(),
                emailAddress = viewModel.emailAddress
            )
        },
        content = {
            HomeScreenBody(
                navController = navController,
                viewModel = viewModel,
                state = state,
                selectedTabIndex = selectedTabIndex,
            ) {
                viewModel.onChangeSelectedTab(it)
            }
        },
        bottomBar = {
            ScreenBottomBar(
                navController = navController
            )
        }
    )
}


@ExperimentalPagerApi
@Composable
private fun HomeScreenBody(
    navController: NavController,
    viewModel: EcommViewModel,
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

        LaunchedEffect(key1 = state.query) {
            delay(100)
            state.searchResults = viewModel.getSearchResults(state.query.text)
            state.searching = false
        }

        // Main Content
        when (state.searchDisplay) {
            SearchDisplay.InitialResults -> {

                when (selectedTabIndex) {
                    OutfitCategory.All.index -> {
                        HomeScreenContentAll(
                            navController = navController,
                            outfitAdList = viewModel.outfitAdList,
                            outfitCampaignList = viewModel.outfitCampaignList,
                            outfitNewProductList = viewModel.outfitNewProductList,
                            onChangeSelectedTab = onChangeSelectedTab,
                        )
                    }

                    OutfitCategory.Women.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = viewModel.outfitWomenList,
                            outfitFavoriteList = viewModel.favoriteOutfitList,
                        )
                    }

                    OutfitCategory.Men.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = viewModel.outfitMenList,
                            outfitFavoriteList = viewModel.favoriteOutfitList,
                        )
                    }

                    OutfitCategory.Accessories.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = viewModel.outfitAccessoriesList,
                            outfitFavoriteList = viewModel.favoriteOutfitList,
                        )
                    }

                    OutfitCategory.HomeDecor.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = viewModel.outfitHomeDecorList,
                            outfitFavoriteList = viewModel.favoriteOutfitList,
                        )
                    }

                    OutfitCategory.Sale.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = viewModel.outfitSaleList,
                            outfitFavoriteList = viewModel.favoriteOutfitList,
                        )
                    }
                }
            }

            SearchDisplay.NoResults -> {
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Results", fontSize = 24.sp, color = colorTextBody)
                }
            }

            SearchDisplay.Results -> {
                LaunchedEffect(Unit) {
                    delay(1500)
                    //updateSearchKeywords(state.query.text)
                    viewModel.updateSearchKeywords(state.query.text)
                }

                HomeScreenContentList(
                    navController = navController,
                    outfitList = viewModel.getSearchResults(state.query.text),
                    outfitFavoriteList = viewModel.favoriteOutfitList,
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CategoryTabs(
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
                    ) {
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
