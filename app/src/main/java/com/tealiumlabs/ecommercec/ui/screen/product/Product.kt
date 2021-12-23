package com.tealiumlabs.ecommercec.ui.screen.product

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.tealiumlabs.ecommercec.model.Outfit
import com.tealiumlabs.ecommercec.model.OutfitInCart
import com.tealiumlabs.ecommercec.ui.components.FavoriteButton
import com.tealiumlabs.ecommercec.ui.components.QuantitySelector
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenTopAppBar
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.screen.home.OutfitImage
import com.tealiumlabs.ecommercec.ui.theme.*
import kotlin.math.max
import kotlin.math.min

private val BottomBarHeight = 56.dp
private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 70.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun ProductScreen(
    viewModel: EcommViewModel,
    navController: NavController,
    outfitId: Long?,
) {
    val outfit = viewModel.getOutfit(outfitId)!!

    Scaffold(
        topBar = {
            HomeScreenTopAppBar(
                navController = navController,
                //outfitsInCart = viewModel.cartAddedOutfitList.size,
                outfitsInCart = viewModel.cartAddedItemsTotalQty(),
                emailAddress = viewModel.emailAddress,
            )
        },
        content = {
            ProductScreenBody(
                outfit = outfit,
                outfitsInCart = viewModel.cartAddedOutfitList,
                outfitFavoriteList = viewModel.favoriteOutfitList,
                upPress = { navController.popBackStack() }
            )
        },
    )
}

@Composable
fun ProductScreenBody(
    outfit: Outfit,
    outfitsInCart: MutableList<OutfitInCart>,
    outfitFavoriteList: MutableList<Outfit>,
    upPress: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val scroll = rememberScrollState(0)

        Header()

        Body(
            outfit = outfit,
            outfitFavoriteList = outfitFavoriteList,
            scroll = scroll
        )

        Title(
            outfit = outfit,
            scroll = scroll.value
        )

        Image(
            imageUrl = outfit.imageUrl_l,
            scroll = scroll.value
        )

        Up {
            upPress()
        }

        CartBottomBar(
            outfit = outfit,
            outfitsInCart = outfitsInCart,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(listOf(colorBackground, Color.White)))
    )
}

@Composable
fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = colorFavoriteBackground,
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = null
        )
    }
}

@Composable
private fun Body(
    outfit: Outfit,
    outfitFavoriteList: MutableList<Outfit>,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))

            Surface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Details",
                            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
                            color = colorDesc,
                            modifier = HzPadding
                                .weight(2f)
                        )

                        Surface(
                            modifier = Modifier.padding(end = 32.dp)
                        ) {
                            FavoriteButton(
                                height = 24.dp,
                                width = 140.dp,
                                isFavorite = outfitFavoriteList.contains(outfit),
                                textSize = 12f
                            ) {
                                if (outfitFavoriteList.contains(outfit)) {
                                    outfitFavoriteList.remove(outfit)
                                    false
                                } else {
                                    outfitFavoriteList.add(outfit)
                                    true
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    var seeMore by remember { mutableStateOf(true) }
                    Text(
                        text = outfit.description,
                        style = MaterialTheme.typography.body1,
                        color = colorDesc,
                        maxLines = if (seeMore) 5 else Int.MAX_VALUE,
                        overflow = TextOverflow.Ellipsis,
                        modifier = HzPadding
                    )
                    val textButton = if (seeMore) {
                        "SEE MORE"
                    } else {
                        "SEE LESS"
                    }
                    Text(
                        text = textButton,
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                        color = Purple700,
                        modifier = Modifier
                            .heightIn(20.dp)
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .clickable {
                                seeMore = !seeMore
                            }
                    )
                    Spacer(Modifier.height(40.dp))

                    Divider(
                        modifier = Modifier.padding(end = 8.dp),
                        color = Color.LightGray,
                        thickness = 1.dp,
                        startIndent = 8.dp
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(bottom = BottomBarHeight)
                            .navigationBarsPadding(start = false, end = false)
                            .height(8.dp)
                    )
                }

            }
        }
    }
}

@Composable
private fun Title(
    outfit: Outfit,
    scroll: Int,
) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val offset = (maxOffset - scroll).coerceAtLeast(minOffset)

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .graphicsLayer { translationY = offset }
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = outfit.name,
            style = MaterialTheme.typography.h4,
            color = colorTextBody,
            modifier = HzPadding
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "$ ${outfit.price}",
            style = EcommTypography.h5.copy(
                color = colorPrice,
                fontSize = 22.sp
            ),
            modifier = HzPadding
        )

        Spacer(Modifier.height(8.dp))

        Divider(
            modifier = Modifier,
            color = Neutral3,
            thickness = 1.dp,
            startIndent = 0.dp
        )
    }
}

@Composable
private fun Image(
    imageUrl: String,
    scroll: Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFraction = (scroll / collapseRange).coerceIn(0f, 1f)


    CollapsingImageLayout(
        collapseFraction = collapseFraction,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        OutfitImage(
            imageUrl = imageUrl,
            modifier = Modifier
                .width(200.dp)
                .height(300.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFraction: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2, // centered when expanded
            constraints.maxWidth - imageWidth, // right aligned when collapsed
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth,
        ) {
            imagePlaceable.placeRelative(imageX, imageY)
        }
    }
}

@Composable
private fun CartBottomBar(
    outfit: Outfit,
    outfitsInCart: MutableList<OutfitInCart>,
    modifier: Modifier = Modifier
) {
    val (count, updateCount) = remember { mutableStateOf(1) }

    Surface(modifier = modifier) {
        Column {
            Divider(
                modifier = Modifier,
                color = Neutral3,
                thickness = 1.dp,
                startIndent = 0.dp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorBackground)
                    .navigationBarsPadding(start = false, end = false)
                    .then(HzPadding)
                    .heightIn(min = BottomBarHeight)
            ) {
                QuantitySelector(
                    count = count,
                    decreaseItemCount = { if (count > 1) updateCount(count - 1) },
                    increaseItemCount = { updateCount(count + 1) }
                )
                Spacer(Modifier.width(16.dp))
                Button(
                    onClick = {

                        val outfitInCart = OutfitInCart(
                            id = outfit.id,
                            colorId = 100, // Dummy
                            quantity = count,
                            outfit = outfit
                        )

                        val tmpList = outfitsInCart.toList()
                        var currentQty = 0

                        var bAlreadyInCart = false
                        tmpList.forEach {
                            if(outfit.id == it.id){
                                bAlreadyInCart = true
                                currentQty = it.quantity

                                outfitsInCart.remove(it)
                            }
                        }

                        if(bAlreadyInCart){
                            outfitInCart.quantity += currentQty
                        }

                        outfitsInCart.add(outfitInCart)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "ADD TO CART",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }
            }
        }
    }
}