package com.tealiumlabs.ecommercec.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.model.Outfit
import com.tealiumlabs.ecommercec.ui.components.GlobalTopAppBar
import com.tealiumlabs.ecommercec.ui.components.ScreenBottomBar
import com.tealiumlabs.ecommercec.ui.screen.home.*
import com.tealiumlabs.ecommercec.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(
    viewModel: EcommViewModel,
    navController: NavController,
    state: SearchState<Outfit> = rememberSearchState(),
) {
    Scaffold(
        topBar = {
            GlobalTopAppBar(
                navController = navController,
                outfitsInCart = viewModel.cartAddedItemsTotalQty(),
                emailAddress = viewModel.emailAddress
            )
        },
        content = {
            SearchScreenContent(
                navController = navController,
                outfitSearchResultList = viewModel.getSearchResults(state.query.text),
                outfitFavoriteList = viewModel.favoriteOutfitList,
                state = state,
                searchedKeywords = viewModel.searchedKeywords,
            ){
                viewModel.updateSearchKeywords(it)
            }
        },
        bottomBar = {
            ScreenBottomBar(
                navController = navController
            )
        }
    )
}

@Composable
fun SearchScreenContent(
    navController: NavController,
    outfitSearchResultList: List<Outfit>,
    outfitFavoriteList: MutableList<Outfit>,
    state: SearchState<Outfit>,
    searchedKeywords: MutableList<String>,
    updateSearchKeywords: (String) -> Unit,
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Search Bar
        GlobalSearch(state)

        LaunchedEffect(key1 = state.query){
            delay(100)
            state.searchResults = outfitSearchResultList
            state.searching = false
        }

        // Main Content
        when (state.searchDisplay) {
            SearchDisplay.InitialResults -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorBackground)
                            .padding(start = 16.dp, top = 12.dp, bottom = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.keyword_history),
                            style = TextStyle(
                               fontSize = 18.sp,
                               fontWeight = FontWeight.SemiBold,
                               color = colorTextBodyLight,
                            )
                        )
                    }

                    searchedKeywords.forEach { keyword ->
                       Box(
                           modifier = Modifier
                               .fillMaxWidth()
                               .clickable {
                                   state.query = TextFieldValue(keyword, TextRange(keyword.length))
                               }
                               .drawBehind {
                                   drawLine(
                                       color = Color.DarkGray,
                                       start = Offset(x = 0f, y = size.height),
                                       end = Offset(x = size.width, y = size.height),
                                       strokeWidth = 1f,
                                       pathEffect = PathEffect.dashPathEffect(
                                           intervals = floatArrayOf(5f, 10f)
                                       )
                                   )
                               }
                               .padding(start = 16.dp, top = 8.dp, bottom = 4.dp, end = 8.dp)
                       ){
                           Row {
                               Text(
                                   text = keyword,
                                   fontSize = 18.sp,
                                   modifier = Modifier.weight(9f)
                               )

                               Icon(
                                   imageVector = Icons.Filled.Search,
                                   contentDescription = null,
                                   modifier = Modifier.weight(1f)
                               )
                           }
                       }
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
                    Text(stringResource(id = R.string.no_result), fontSize = 24.sp, color = colorTextBody)
                }
            }

            SearchDisplay.Results -> {

                LaunchedEffect(Unit){
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
