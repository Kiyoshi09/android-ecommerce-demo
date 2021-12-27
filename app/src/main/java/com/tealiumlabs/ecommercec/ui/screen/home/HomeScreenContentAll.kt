package com.tealiumlabs.ecommercec.ui.screen.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.Outfit
import com.tealiumlabs.ecommercec.model.OutfitAd
import com.tealiumlabs.ecommercec.model.OutfitCampaign
import com.tealiumlabs.ecommercec.model.OutfitCategory
import com.tealiumlabs.ecommercec.ui.components.ECommcSurface
import com.tealiumlabs.ecommercec.ui.navigation.moveToProductScreen
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography
import com.tealiumlabs.ecommercec.ui.theme.colorPrice


@ExperimentalPagerApi
@Composable
fun HomeScreenContentAll(
    navController: NavController,
    outfitAdList: List<OutfitAd>,
    outfitCampaignList: List<OutfitCampaign>,
    outfitNewProductList: List<Outfit>,
    onChangeSelectedTab: (Int) -> Unit,
) {
    val pageState = rememberPagerState()

    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            item {
                HorizontalPager(
                    state = pageState,
                    count = outfitAdList.size,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(8.dp)
                ) {
                    OutfitAdItem(
                        outfitAd = outfitAdList[it]
                    ) { outfitCategory ->
                        //Log.i("Kiyoshi", "Outfit Ad : $outfitCategory")
                        onChangeSelectedTab(outfitCategory.index)
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                )
                {
                    Indicators(
                        currentPosition = pageState.currentPage,
                        contentCount = outfitAdList.size
                    )
                }
            }

            item {
                LazyRow {
                    itemsIndexed(outfitCampaignList) { _, outfitCampain ->
                        OutfitCampaignItem(
                            outfitCampaign = outfitCampain
                        )
                        { outfitCategory ->
                            //Log.i("Kiyoshi", "Outfit Campaign/Banner : $outfitCategory")
                            onChangeSelectedTab(outfitCategory.index)
                        }
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NEW PRODUCTS",
                        style = EcommTypography.subtitle2
                    )
                }
            }

            for (i in outfitNewProductList.indices step 2) {
                item {
                    OutfitNewProduct(
                        navController = navController,
                        outfitNewProduct1 = outfitNewProductList[i],
                        outfitNewProduct2 = outfitNewProductList[i + 1]
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
private fun Indicators(currentPosition: Int, contentCount: Int) {
    Row(
        modifier = Modifier.width((12 * contentCount).dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        repeat(contentCount) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(shape = CircleShape)
                    .background(color = if (currentPosition == it) Color(0xFF4382D3) else Color.Gray),
            )
        }
    }
}


@Composable
private fun OutfitAdItem(
    outfitAd: OutfitAd,
    onOutfitAdClick: (OutfitCategory) -> Unit
) {
    ECommcSurface(
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable {
                    onOutfitAdClick(outfitAd.category)
                }
        ) {
            OutfitImage(
                imageUrl = outfitAd.imageUrl,
                elevation = 4.dp,
                contentDescription = null,
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
private fun OutfitCampaignItem(
    outfitCampaign: OutfitCampaign,
    onOutfitCampaignClick: (OutfitCategory) -> Unit
) {
    ECommcSurface(
        shape = MaterialTheme.shapes.medium,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable {
                    onOutfitCampaignClick(outfitCampaign.category)
                },
            Alignment.Center
        ) {
            OutfitImage(
                imageUrl = outfitCampaign.imageUrl,
                modifier = Modifier
                    .width(250.dp)
                    .height(90.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
private fun OutfitNewProduct(
    navController: NavController,
    outfitNewProduct1: Outfit,
    outfitNewProduct2: Outfit
) {
    val products = listOf(outfitNewProduct1, outfitNewProduct2)

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        products.forEach { product ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        moveToProductScreen(
                            navController = navController,
                            prodId = product.id,
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutfitImage(
                        imageUrl = product.imageUrl_s,
                        elevation = 0.1.dp,
                        modifier = Modifier
                            .width(147.dp)
                            .height(147.dp),
                        contentScale = ContentScale.FillWidth
                    )

                    Text(
                        text = product.name,
                        style = EcommTypography.h5.copy(fontSize = 14.sp),
                        softWrap = true,
                        maxLines = 2,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "$ ${product.price}",
                        style = EcommTypography.h5.copy(fontSize = 14.sp, color = colorPrice),
                        softWrap = true,
                        maxLines = 2,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun OutfitImage(
    imageUrl: String,
    contentDescription: String? = null,
    modifier: Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = 0.dp,
    contentScale: ContentScale = ContentScale.Fit
) {
    ECommcSurface(
        elevation = elevation,
        shape = shape,
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
            contentScale = contentScale
        )
    }
}
