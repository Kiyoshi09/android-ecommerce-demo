package com.tealiumlabs.ecommercec.ui.screen.cart

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.OutfitInCart
import com.tealiumlabs.ecommercec.ui.components.QuantitySelectorSmall
import com.tealiumlabs.ecommercec.ui.navigation.moveToCheckoutScreen
import com.tealiumlabs.ecommercec.ui.navigation.moveToProductScreen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenTopAppBar
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.screen.product.Up
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun CartScreen(
    viewModel: EcommViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {

            HomeScreenTopAppBar(
                navController = navController,
                outfitsInCart = viewModel.cartAddedItemsTotalQty(),
                emailAddress = viewModel.emailAddress,
            )
        },
        content = {
            CartScreenBody(
                navController = navController,
                outfitsInCart = viewModel.cartAddedOutfitList,
                orderTotal = viewModel.orderTotal().value,
                upPress = { navController.navigateUp() }
            ) {
                viewModel.removeFromCart(it)
            }
        },
        bottomBar = {
            HomeScreenBottomBar(
                navController = navController
            )
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CartScreenBody(
    navController: NavController,
    outfitsInCart: MutableList<OutfitInCart>,
    orderTotal: Double,
    upPress: () -> Unit,
    removeFromCart: (OutfitInCart) -> Unit,
) {
    Up {
        upPress()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Surface(
                        modifier = Modifier
                            .weight(3f)
                    ) {
                        Text(
                            text = "Total :",
                            style = EcommTypography.h5.copy(
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.SemiBold,
                            )
                        )
                    }

                    Surface(
                        modifier = Modifier
                            .weight(2f)
                    ) {
                        Text(
                            text = "$ $orderTotal",
                            style = EcommTypography.h4.copy(
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }
            }
        }

        val b = outfitsInCart.size > 0

        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Button(
                    enabled = b,
                    onClick = {
                              moveToCheckoutScreen(navController = navController)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Text(text = "PROCEED TO CHECKOUT")
                }
            }
        }

        itemsIndexed(outfitsInCart) { _, outfitInCart ->
            Surface(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
                    .clickable {
                        moveToProductScreen(
                            navController = navController,
                            prodId = outfitInCart.outfit.id,
                        )
                    }
            ) {
                Column {
                    val (count, updateCount) = remember { mutableStateOf(outfitInCart.quantity) }
                    outfitInCart.quantity = count

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(4.dp),
                        ) {
                            Image(
                                painter = rememberImagePainter(
                                    data = outfitInCart.outfit.imageUrl_s,
                                    builder = {
                                        crossfade(true)
                                        placeholder(drawableResId = R.drawable.plate_placeholder)
                                    }
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(84.dp)
                                    .height(84.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        Box(
                            modifier = Modifier.padding(start = 16.dp)
                        ) {
                            Column {
                                Row {
                                    Box(
                                        modifier = Modifier
                                            .weight(2f),
                                        Alignment.CenterStart
                                    ) {
                                        Text(
                                            text = outfitInCart.outfit.name,
                                            style = EcommTypography.h5.copy(
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.SemiBold,
                                            ),
                                            softWrap = true
                                        )
                                    }

                                    IconButton(onClick = {
                                        removeFromCart(outfitInCart)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Outlined.DeleteForever,
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp),
                                            tint = Shadow11
                                        )
                                    }
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.Bottom
                                ) {
                                    Spacer(modifier = Modifier.width(32.dp))
                                    Text(
                                        text = "Color : White",
                                        style = EcommTypography.h5.copy(
                                            fontSize = 12.sp,
                                        ),
                                        softWrap = true,
                                        modifier = Modifier
                                            .weight(4f)
                                            .padding(top = 4.dp)
                                    )

                                    Text(
                                        text = "Price : $ ${outfitInCart.outfit.price}",
                                        style = EcommTypography.h5.copy(
                                            fontSize = 14.sp,
                                            textAlign = TextAlign.End,
                                        ),
                                        softWrap = true,
                                        modifier = Modifier
                                            .padding(end = 8.dp)
                                            .weight(6f)
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Spacer(modifier = Modifier.width(32.dp))
                                    Surface(
                                        modifier = Modifier.weight(4f)
                                    ) {
                                        Text(
                                            text = "Size : XL",
                                            style = EcommTypography.h5.copy(
                                                fontSize = 12.sp
                                            ),
                                            softWrap = true
                                        )
                                    }

                                    Surface(
                                        modifier = Modifier
                                            .weight(6f)
                                            .padding(start = 8.dp)
                                    ) {
                                        QuantitySelectorSmall(
                                            count = count,
                                            decreaseItemCount = {
                                                if (count > 1) updateCount(
                                                    count - 1
                                                )
                                            },
                                            increaseItemCount = { updateCount(count + 1) }
                                        )
                                    }
                                }
                            }

                        }
                    }
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = veryLighGray,
                        thickness = 1.dp,
                        startIndent = 0.dp
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

