package com.tealiumlabs.ecommercec.ui.screen.checkout

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.model.CheckoutInfo
import com.tealiumlabs.ecommercec.model.OutfitInCart
import com.tealiumlabs.ecommercec.ui.components.CustomTextField
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenTopAppBar
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.screen.product.Up
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun CheckoutScreen(
    viewModel: EcommViewModel,
    navController: NavController
) {
    val checkoutInfo = remember {
        CheckoutInfo(
            billName = mutableStateOf("Benjamin Linus"),
            billAddress = mutableStateOf("29 Wilson Ave. Bethlehem, PA"),
            billZip = mutableStateOf("18015"),
            billPhone = mutableStateOf("202-555-0107"),
            email = mutableStateOf(viewModel.emailAddress.value),
            shipName = mutableStateOf("Benjamin Linus"),
            shipAddress = mutableStateOf("61 Hanover Street Ridgewood, NJ"),
            shipZip = mutableStateOf("07450"),
            shipPhone = mutableStateOf("202-555-0125"),
            shipMethod = mutableStateOf("")
        )
    }

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
            CheckoutScreenBody(
                navController = navController,
                checkoutInfo = checkoutInfo,
                outfitsInCart = viewModel.cartAddedOutfitList,
                orderTotal = viewModel.orderTotal(),
            ) {
                navController.navigateUp()
            }
        },
        bottomBar = {
            HomeScreenBottomBar(
                navController = navController
            )
        },
    )
}

@Composable
private fun CheckoutScreenBody(
    navController: NavController,
    checkoutInfo: CheckoutInfo,
    outfitsInCart: MutableList<OutfitInCart>,
    orderTotal: MutableState<Double>,
    upPress: () -> Unit,
) {
    Column {

        Row {
            Up {
                upPress()
            }

            Spacer(Modifier.width(80.dp))

            Text(
                text = "CHECKOUT",
                style = EcommTypography.subtitle1,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        val billingInfo = remember { mutableStateOf(true) }
        val shippingInfo = remember { mutableStateOf(false) }
        val shippingMethod = remember { mutableStateOf(false) }
        val paymentInfo = remember { mutableStateOf(false) }
        val orderReview = remember { mutableStateOf(false) }

        val billingInfoComplete = remember { mutableStateOf(false) }
        val shippingInfoComplete = remember { mutableStateOf(false) }
        val shippingMethodComplete = remember { mutableStateOf(false) }
        val paymentInfoComplete = remember { mutableStateOf(false) }
        val orderReviewComplete = remember { mutableStateOf(false) }

        LazyColumn {

            item {
                ExpandableCard(
                    card = "BILLING INFORMATION",
                    onCardArrowClick = {
                        billingInfo.value = !billingInfo.value
                        billingInfoComplete.value = false
                    },
                    expanded = billingInfo.value,
                    complete = billingInfoComplete.value,
                ) {
                    ContentsBillingInfo(
                        checkoutInfo = checkoutInfo,
                        currentExpand = billingInfo,
                        nextExpand = shippingInfo,
                        complete = billingInfoComplete,
                    )
                }
            }

            item {
                ExpandableCard(
                    card = "SHIPPING INFORMATION",
                    onCardArrowClick = {
                        shippingInfo.value = !shippingInfo.value
                        shippingInfoComplete.value = false
                    },
                    expanded = shippingInfo.value,
                    complete = shippingInfoComplete.value,
                ) {
                    ContentsShippingInfo(
                        checkoutInfo = checkoutInfo,
                        currentExpand = shippingInfo,
                        nextExpand = shippingMethod,
                        complete = shippingInfoComplete,
                    )
                }
            }

            item {
                ExpandableCard(
                    card = "SHIPPING METHOD",
                    onCardArrowClick = {
                        shippingMethod.value = !shippingMethod.value
                        shippingMethodComplete.value = false
                    },
                    expanded = shippingMethod.value,
                    complete = shippingMethodComplete.value,
                )
                {
                    ContentsShippingMethod(
                        checkoutInfo = checkoutInfo,
                        currentExpand = shippingMethod,
                        nextExpand = paymentInfo,
                        complete = shippingMethodComplete,
                    )
                }
            }

            item {
                ExpandableCard(
                    card = "PAYMENT INFORMATION",
                    onCardArrowClick = {
                        paymentInfo.value = !paymentInfo.value
                        paymentInfoComplete.value = false
                    },
                    expanded = paymentInfo.value,
                    complete = paymentInfoComplete.value,
                ) {
                    ContentsPaymentInfo(
                        currentExpand = paymentInfo,
                        nextExpand = orderReview,
                        complete = paymentInfoComplete,
                    )
                }
            }

            item {
                ExpandableCard(
                    card = "ORDER REVIEW",
                    onCardArrowClick = {
                        orderReview.value = !orderReview.value
                        orderReviewComplete.value = false
                    },
                    expanded = orderReview.value,
                    complete = orderReviewComplete.value
                ) {
                    ContentsOrderReview(
                        navController = navController,
                        checkoutInfo = checkoutInfo,
                        outfitsInCart = outfitsInCart,
                        orderTotal = orderTotal,
                        complete = orderReviewComplete,
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(70.dp))
            }
        }

    }
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
private fun ExpandableCard(
    card: String,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    complete: Boolean,
    contents: @Composable () -> Unit,
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState, label = "")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = 300)
    }, label = "") {
        if (expanded) Color.White else Color.White
    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = 300)
    }, label = "") {
        if (expanded) 32.dp else 24.dp
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = 300)
    }, label = "") {
        if (expanded) 24.dp else 4.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = 300,
            easing = FastOutSlowInEasing
        )
    }, label = "") {
        if (expanded) 0.dp else 4.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = 300)
    }, label = "") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
//        contentColor = Color(
//            ContextCompat.getColor(
//                LocalContext.current,
//                R.color.colorTextBodyLight
//            )
//        ),
        contentColor = Shadow10,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = 8.dp
            )
    )
    {
        Column {
            Box(
                modifier = Modifier.clickable { onCardArrowClick() }
            ) {
                CardArrow(
                    degrees = arrowRotationDegree,
                    onClick = onCardArrowClick,
                )

                CardTitle(title = card)

                if (complete) {
                    Icon(
                        imageVector = Icons.Filled.TaskAlt,
                        contentDescription = null,
                        tint = Ocean8,
                        modifier = Modifier.padding(start = 312.dp, top = 16.dp)
                    )
                }
            }
            ExpandableContent(visible = expanded, initialVisibility = expanded, contents = contents)
        }
    }
}

@Composable
private fun CardTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 48.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        textAlign = TextAlign.Start,
    )
}

@Composable
private fun CardArrow(
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                imageVector = Icons.Filled.ArrowCircleUp,
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
            )
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("RememberReturnType")
@Composable
private fun ExpandableContent(
    visible: Boolean = true,
    initialVisibility: Boolean = false,
    contents: @Composable () -> Unit,
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = 350,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(300))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(300))
    }
    AnimatedVisibility(
        visible = visible,
        initiallyVisible = initialVisibility,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        contents()
    }
}

@Composable
private fun ContentsBillingInfo(
    checkoutInfo: CheckoutInfo,
    currentExpand: MutableState<Boolean>,
    nextExpand: MutableState<Boolean>,
    complete: MutableState<Boolean>,
) {
    val focusRequesters = List(6) { FocusRequester() }

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Name",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Name",
            bgColor = Rose1,
            stateValue = checkoutInfo.billName,
            focusRequestN = focusRequesters[0],
            focusRequestN1 = focusRequesters[1],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Address",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Address",
            bgColor = Rose1,
            stateValue = checkoutInfo.billAddress,
            focusRequestN = focusRequesters[1],
            focusRequestN1 = focusRequesters[2],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Zip/Postal Code",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Zip/Postal Code",
            bgColor = Rose1,
            stateValue = checkoutInfo.billZip,
            focusRequestN = focusRequesters[2],
            focusRequestN1 = focusRequesters[3],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Email address",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Email address",
            bgColor = Rose1,
            stateValue = checkoutInfo.email,
            focusRequestN = focusRequesters[3],
            focusRequestN1 = focusRequesters[4],
            fontSize = 18.sp,
            icon = Icons.Filled.Email,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Telephone",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Telephone",
            bgColor = Rose1,
            stateValue = checkoutInfo.billPhone,
            focusRequestN = focusRequesters[4],
            focusRequestN1 = focusRequesters[5],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                currentExpand.value = false
                nextExpand.value = true
                complete.value = true
            },
            modifier = Modifier
                .size(160.dp, 40.dp)
                .focusOrder(focusRequesters[5]) {
                }
        ) {
            Text("CONTINUE")
        }


    }
}

@Composable
private fun ContentsShippingInfo(
    checkoutInfo: CheckoutInfo,
    currentExpand: MutableState<Boolean>,
    nextExpand: MutableState<Boolean>,
    complete: MutableState<Boolean>,
) {
    val focusRequesters = List(5) { FocusRequester() }

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Name",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Name",
            bgColor = Rose1,
            stateValue = checkoutInfo.shipName,
            focusRequestN = focusRequesters[0],
            focusRequestN1 = focusRequesters[1],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Address",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Address",
            bgColor = Rose1,
            stateValue = checkoutInfo.shipAddress,
            focusRequestN = focusRequesters[1],
            focusRequestN1 = focusRequesters[2],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Zip/Postal Code",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Zip/Postal Code",
            bgColor = Rose1,
            stateValue = checkoutInfo.shipZip,
            focusRequestN = focusRequesters[2],
            focusRequestN1 = focusRequesters[3],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Telephone",
            style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
            color = colorDesc,
        )

        CustomTextField(
            textValue = "Telephone",
            bgColor = Rose1,
            stateValue = checkoutInfo.shipPhone,
            focusRequestN = focusRequesters[3],
            focusRequestN1 = focusRequesters[4],
            fontSize = 18.sp,
            icon = Icons.Filled.TextFields,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                currentExpand.value = false
                nextExpand.value = true
                complete.value = true
            },
            modifier = Modifier
                .size(160.dp, 40.dp)
                .focusOrder(focusRequesters[4]) {
                }
        ) {
            Text("CONTINUE")
        }


    }
}

@Composable
private fun ContentsShippingMethod(
    checkoutInfo: CheckoutInfo,
    currentExpand: MutableState<Boolean>,
    nextExpand: MutableState<Boolean>,
    complete: MutableState<Boolean>,
) {
    val shippingMethod = remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.padding(8.dp),
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = shippingMethod.value,
                onClick = {
                    shippingMethod.value = !shippingMethod.value
                }
            )
            Text(
                text = "Flat Rate",
                style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
                color = colorDesc,
            )

            Spacer(modifier = Modifier.width(32.dp))

            RadioButton(
                selected = !shippingMethod.value,
                onClick = {
                    shippingMethod.value = !shippingMethod.value
                }
            )

            Text(
                text = "Free Shipping",
                style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
                color = colorDesc,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                currentExpand.value = false
                nextExpand.value = true
                complete.value = true

                checkoutInfo.shipMethod.value =
                    if (shippingMethod.value) "Flat Rate" else "Free Shipping"
            },
            modifier = Modifier
                .size(160.dp, 40.dp)
        ) {
            Text("CONTINUE")
        }
    }
}

@Composable
private fun ContentsPaymentInfo(
    currentExpand: MutableState<Boolean>,
    nextExpand: MutableState<Boolean>,
    complete: MutableState<Boolean>,
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Cash On Delivery",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h5.copy(textAlign = TextAlign.Center),
            color = colorDesc,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                currentExpand.value = false
                nextExpand.value = true
                complete.value = true
            },
            modifier = Modifier
                .size(160.dp, 40.dp)
        ) {
            Text("CONTINUE")
        }
    }
}

@Composable
private fun ContentsOrderReview(
    navController: NavController,
    checkoutInfo: CheckoutInfo,
    outfitsInCart: MutableList<OutfitInCart>,
    orderTotal: MutableState<Double>,
    complete: MutableState<Boolean>,
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row {
            Column(
                modifier = Modifier.weight(.5f)
            ) {
                Text(
                    text = "BILLING ADDRESS",
                    style = MaterialTheme.typography.h5.copy(fontSize = 14.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.billName.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.email.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.billAddress.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.billZip.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.billPhone.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "SHIPPING METHOD",
                    style = MaterialTheme.typography.h5.copy(fontSize = 14.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.shipMethod.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
            }

            Column(
                modifier = Modifier.weight(.5f)
            ) {
                Text(
                    text = "SHIPPING ADDRESS",
                    style = MaterialTheme.typography.h5.copy(fontSize = 14.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.shipName.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.shipAddress.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.shipZip.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = checkoutInfo.shipPhone.value,
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
                Text(
                    text = "",
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "PAYMENT METHOD",
                    style = MaterialTheme.typography.h5.copy(fontSize = 14.sp, color = colorDesc),
                )
                Text(
                    text = "Cash On Delivery",
                    style = MaterialTheme.typography.h5.copy(fontSize = 9.sp, color = colorDesc),
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Row(
                Modifier
                    .background(Color.LightGray)
            ) {
                Text(
                    text = "PRODUCT",
                    style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                    modifier = Modifier.weight(.5f)
                )
                Text(
                    text = "PRICE",
                    style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                    modifier = Modifier.weight(.2f)
                )
                Text(
                    text = "QTY",
                    style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc, textAlign = TextAlign.Center),
                    modifier = Modifier.weight(.1f)
                )
                Text(
                    text = "SUBTOTAL",
                    style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                    modifier = Modifier.weight(.2f)
                )
            }

            outfitsInCart.forEach { outfitInCart ->
                Row {
                    Column(
                        modifier = Modifier.weight(.5f)
                    ) {
                        Text(
                            text = outfitInCart.outfit.name,
                            style = MaterialTheme.typography.h5.copy(
                                fontSize = 11.sp,
                                color = colorDesc,
                                fontWeight = FontWeight.SemiBold
                            ),
                        )

                        Text(
                            text = "Color: White",
                            style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                            modifier = Modifier.padding(start = 8.dp)
                        )

                        Text(
                            text = "Size: XL",
                            style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Text(
                        text = "$ ${outfitInCart.outfit.price}",
                        style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                        modifier = Modifier.weight(.2f)
                    )
                    Text(
                        text = "${outfitInCart.quantity}",
                        style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc, textAlign = TextAlign.Center),
                        modifier = Modifier.weight(.1f)
                    )
                    Text(
                        text = "$ ${outfitInCart.outfit.price * outfitInCart.quantity}",
                        style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc),
                        modifier = Modifier.weight(.2f)
                    )
                }
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = veryLighGray,
                    thickness = 1.dp,
                    startIndent = 0.dp
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "TOTAL : ${orderTotal.value}",
                    style = MaterialTheme.typography.h5.copy(fontSize = 11.sp, color = colorDesc, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                complete.value = true

                outfitsInCart.removeAll(outfitsInCart)

                navController.navigate(Screen.Complete.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            },
            modifier = Modifier
                .size(160.dp, 40.dp)
        ) {
            Text("PURCHASE")
        }
    }
}
