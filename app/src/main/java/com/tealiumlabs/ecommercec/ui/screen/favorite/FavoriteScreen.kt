package com.tealiumlabs.ecommercec.ui.screen.favorite

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.model.Outfit
import com.tealiumlabs.ecommercec.ui.navigation.moveToProductScreen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenTopAppBar
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.screen.home.OutfitImage
import com.tealiumlabs.ecommercec.ui.screen.product.Header
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun FavoriteScreen(
    viewModel: EcommViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            HomeScreenTopAppBar(
                navController = navController,
                outfitsInCart = viewModel.cartAddedOutfitList.size,
                emailAddress = viewModel.emailAddress
            )
        },
        content = {
            Header()

            FavoriteScreenContent(
                navController = navController,
                outfitFavoriteList = viewModel.favoriteOutfitList,
            ){
                viewModel.removeItemFromFavoriteOutfitList(it)
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
private fun FavoriteScreenContent(
    navController: NavController,
    outfitFavoriteList: MutableList<Outfit>,
    removeFromFavoriteList: (Outfit) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {

        item {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "My Favorites",
                    style = EcommTypography.subtitle2
                )
            }
        }

        for (index in 0 until outfitFavoriteList.size step 2) {
            val outfitFavoriteLeft = outfitFavoriteList[index]

            item {
                Row(
                    modifier = Modifier
                        .padding(8.dp),
                ) {
                    FavoriteOutfit(
                        navController = navController,
                        outfitFavorite = outfitFavoriteLeft,
                        removeFromFavoriteList = removeFromFavoriteList,
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    if (index + 1 < outfitFavoriteList.size) {
                        val outfitFavoriteRight = outfitFavoriteList[index + 1]
                        FavoriteOutfit(
                            navController = navController,
                            outfitFavorite = outfitFavoriteRight,
                            removeFromFavoriteList = removeFromFavoriteList,
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@Composable
private fun FavoriteOutfit(
    navController: NavController,
    outfitFavorite: Outfit,
    removeFromFavoriteList: (Outfit) -> Unit,
) {
    Surface(
        modifier = Modifier
            .size(
                width = 180.dp,
                height = 230.dp
            )
            .clip(RoundedCornerShape(1.dp)),
        border = BorderStroke(width = 0.2.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    moveToProductScreen(
                        navController = navController,
                        prodId = outfitFavorite.id,
                    )
                }
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
                    .fillMaxWidth()
                    .height(20.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                val isFavorite = mutableStateOf(true)

                IconButton(
                    onClick = {
                        isFavorite.value = false

                        // remove ...
                        removeFromFavoriteList(outfitFavorite)
                    }
                ) {
                    Icon(
                        imageVector =
                        if (isFavorite.value) {
                            Icons.Outlined.Favorite
                        } else {
                            Icons.Outlined.FavoriteBorder
                        },
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.LightGray
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(colorFavoriteBackground)
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center,
            ) {
                OutfitImage(
                    imageUrl = outfitFavorite.imageUrl_s,
                    shape = CircleShape,
                    elevation = 4.dp,
                    modifier = Modifier
                        .width(105.dp)
                        .height(105.dp),
                    contentScale = ContentScale.FillWidth
                )
            }

            Text(
                text = outfitFavorite.name,
                modifier = Modifier.padding(4.dp),
                style = EcommTypography.h5.copy(
                    fontSize = 14.sp
                ),
                softWrap = true,
                textAlign = TextAlign.Center
            )

            Text(
                text = "$ ${outfitFavorite.price}",
                style = EcommTypography.h5.copy(
                    fontSize = 12.sp,
                    color = colorPrice,
                ),
                softWrap = true,
            )
        }
    }
}


