package com.tealiumlabs.ecommercec.ui.screen.home

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.data.prefsStore.readTealiumAccountSettings
import com.tealiumlabs.ecommercec.data.prefsStore.saveTealiumAccountSettings
import com.tealiumlabs.ecommercec.model.*
import com.tealiumlabs.ecommercec.ui.components.CustomTextField
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.search.SearchBar
import com.tealiumlabs.ecommercec.ui.screen.search.SearchDisplay
import com.tealiumlabs.ecommercec.ui.screen.search.SearchState
import com.tealiumlabs.ecommercec.ui.screen.search.rememberSearchState
import com.tealiumlabs.ecommercec.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

    Log.i("KIYOSHI-TEAL", "[tealium settings] " +
            "account:${viewModel.tealiumAccount.value}, " +
            "profile:${viewModel.tealiumProfile.value}, " +
            "dataSource:${viewModel.tealiumDataSource.value}, " +
            "environment:${viewModel.tealiumEnvironment.value}"
    )

    Scaffold(
        topBar = {
            HomeScreenTopAppBar(
                navController = navController,
                outfitsInCart = viewModel.cartAddedItemsTotalQty(),
                emailAddress = viewModel.emailAddress
            )
        },
        content = {
            HomeScreenBody(
                navController = navController,
                outfitAdList = viewModel.outfitAdList,
                outfitCampaignList = viewModel.outfitCampaignList,
                outfitNewProductList = viewModel.outfitNewProductList,
                outfitWomenList = viewModel.outfitWomenList,
                outfitMenList = viewModel.outfitMenList,
                outfitAccessoriesList = viewModel.outfitAccessoriesList,
                outfitHomeDecorList = viewModel.outfitHomeDecorList,
                outfitSaleList = viewModel.outfitSaleList,
                outfitSearchResultList = viewModel.getSearchResults(state.query.text),
                outfitFavoriteList = viewModel.favoriteOutfitList,
                state = state,
                updateSearchKeywords = { viewModel.updateSearchKeywords(state.query.text) },
                selectedTabIndex = selectedTabIndex,
            ) {
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


@ExperimentalPagerApi
@Composable
private fun HomeScreenBody(
    navController: NavController,
    outfitAdList: List<OutfitAd>,
    outfitCampaignList: List<OutfitCampaign>,
    outfitNewProductList: List<Outfit>,
    outfitWomenList: List<Outfit>,
    outfitMenList: List<Outfit>,
    outfitAccessoriesList: List<Outfit>,
    outfitHomeDecorList: List<Outfit>,
    outfitSaleList: List<Outfit>,
    outfitSearchResultList: List<Outfit>,
    outfitFavoriteList: MutableList<Outfit>,
    state: SearchState<Outfit>,
    updateSearchKeywords: (String) -> Unit,
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
                            navController = navController,
                            outfitAdList = outfitAdList,
                            outfitCampaignList = outfitCampaignList,
                            outfitNewProductList = outfitNewProductList,
                            onChangeSelectedTab = onChangeSelectedTab,
                        )
                    }

                    OutfitCategory.Women.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = outfitWomenList,
                            outfitFavoriteList = outfitFavoriteList,
                        )
                    }

                    OutfitCategory.Men.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = outfitMenList,
                            outfitFavoriteList = outfitFavoriteList,
                        )
                    }

                    OutfitCategory.Accessories.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = outfitAccessoriesList,
                            outfitFavoriteList = outfitFavoriteList,
                        )
                    }

                    OutfitCategory.HomeDecor.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = outfitHomeDecorList,
                            outfitFavoriteList = outfitFavoriteList,
                        )
                    }

                    OutfitCategory.Sale.index -> {
                        HomeScreenContentList(
                            navController = navController,
                            outfitList = outfitSaleList,
                            outfitFavoriteList = outfitFavoriteList,
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
                Log.i("Kiyoshi", "Search Display Results")

                LaunchedEffect(Unit) {
                    delay(1500)
                    updateSearchKeywords(state.query.text)
                }

                HomeScreenContentList(
                    navController = navController,
                    outfitList = outfitSearchResultList,
                    outfitFavoriteList = outfitFavoriteList,
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

@Composable
private fun LoginDialog(
    openDialog: MutableState<Boolean>,
    emailAddress: MutableState<String>,
) {
    val emailVal = remember { mutableStateOf(emailAddress.value) }
    val passwordVal = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val traceVal = remember { mutableStateOf("") }

    val focusRequesters = List(4) { FocusRequester() }

    if (openDialog.value) {
        Dialog(
            onDismissRequest = { openDialog.value = false }
        ) {
            Surface(
                modifier = Modifier
                    .size(300.dp, 240.dp)
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = "Sign In",
                        modifier = Modifier.fillMaxWidth(),
                        style = EcommTypography.subtitle1,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        textValue = "Email address",
                        bgColor = colorTextBodyLight,
                        stateValue = emailVal,
                        focusRequestN = focusRequesters[0],
                        focusRequestN1 = focusRequesters[1],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Email
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = "Password",
                        bgColor = colorTextBodyLight,
                        stateValue = passwordVal,
                        passwordVisibility = passwordVisibility,
                        focusRequestN = focusRequesters[1],
                        focusRequestN1 = focusRequesters[2],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Lock,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = "Trace ID",
                        bgColor = colorTextBodyLight,
                        stateValue = traceVal,
                        focusRequestN = focusRequesters[2],
                        focusRequestN1 = focusRequesters[3],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Radar,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            emailAddress.value = emailVal.value
                            openDialog.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusOrder(focusRequesters[3]) {
                            }
                    ) {
                        Text("Login")
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreenTopAppBar(
    navController: NavController,
    outfitsInCart: Int,
    emailAddress: MutableState<String>,
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
            modifier = Modifier.weight(7f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tealium Commerce",
                Modifier.padding(20.dp, 8.dp, 0.dp, 0.dp),
                style = EcommTypography.subtitle1.copy(
                    fontSize = 18.sp
                )
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            val openDialog = remember { mutableStateOf(false) }

            IconButton(onClick = {
                openDialog.value = true
            }) {
                if(emailAddress.value.isEmpty()){
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null
                    )
                }
                else {
                    Icon(
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = null,
                        tint = Color.Blue,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            if (openDialog.value) {
                LoginDialog(
                    openDialog = openDialog,
                    emailAddress = emailAddress,
                )
            }
        }

        Column(
            modifier = Modifier.weight(1.5f),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.Cart.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            }) {
                if (outfitsInCart > 0) {
                    BadgeBox(
                        badgeContent = { Text(text = outfitsInCart.toString()) }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart),
                            contentDescription = "Cart",
                            tint = colors.onSurface,
                        )
                    }
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cart),
                        contentDescription = "Cart",
                        tint = colors.onSurface,
                    )
                }
            }
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

@Composable
fun TealiumProfileConfigureDialog(
    openDialog: MutableState<Boolean>,
    account: String,
    profile: String,
    dataSource: String,
    environment: String,
) {
    val acct = remember { mutableStateOf(account) }
    val prof = remember { mutableStateOf(profile) }
    val ds = remember { mutableStateOf(dataSource) }
    val env = remember { mutableStateOf(environment) }

    val focusRequesters = List(6) { FocusRequester() }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    if (openDialog.value) {

        Dialog(
            onDismissRequest = { openDialog.value = false }
        ) {
            Surface(
                modifier = Modifier
                    .size(300.dp, 260.dp)
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = "Tealium Account Information",
                        modifier = Modifier.fillMaxWidth(),
                        style = EcommTypography.subtitle1.copy(fontSize = 16.sp),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        textValue = "Account",
                        bgColor = colorTextBodyLight,
                        stateValue = acct,
                        focusRequestN = focusRequesters[0],
                        focusRequestN1 = focusRequesters[1],
                        fontSize = 16.sp,
                        icon = Icons.Filled.AccountBox,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = "Profile",
                        bgColor = colorTextBodyLight,
                        stateValue = prof,
                        focusRequestN = focusRequesters[1],
                        focusRequestN1 = focusRequesters[2],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Campaign,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = "DataSource",
                        bgColor = colorTextBodyLight,
                        stateValue = ds,
                        focusRequestN = focusRequesters[2],
                        focusRequestN1 = focusRequesters[3],
                        fontSize = 16.sp,
                        icon = Icons.Filled.DataUsage,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = "Environment",
                        bgColor = colorTextBodyLight,
                        stateValue = env,
                        focusRequestN = focusRequesters[3],
                        focusRequestN1 = focusRequesters[4],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Architecture,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Button(
                            onClick = {
                                acct.value = ""
                                prof.value = ""
                                ds.value = ""
                                env.value = ""
                            },
                            modifier = Modifier
                                .weight(0.5f)
                                .padding(4.dp)
                                .focusOrder(focusRequesters[4]) {
                                }
                        ) {
                            Text("Clear")
                        }

                        Button(
                            onClick = {
                                val tealConfigStr = "${acct.value};${prof.value};${ds.value};${env.value}"

                                scope.launch {
                                    saveTealiumAccountSettings(
                                        context = context,
                                        tealConfig = tealConfigStr,
                                    )
                                }

                                openDialog.value = false
                            },
                            modifier = Modifier
                                .weight(0.5f)
                                .padding(4.dp)
                                .focusOrder(focusRequesters[5]) {
                                }
                        ) {
                            Text("Save")
                        }

                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
        }
    }
}