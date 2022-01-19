package com.tealiumlabs.ecommercec.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.tealium.TealiumHelperList
import com.tealiumlabs.ecommercec.ui.navigation.Screen
import com.tealiumlabs.ecommercec.ui.theme.EcommTypography
import com.tealiumlabs.ecommercec.ui.theme.colorTextBodyLight
import com.tealiumlabs.ecommercec.ui.theme.veryLighGray


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GlobalTopAppBar(
    navController: NavController,
    outfitsInCart: Int,
    emailAddress: MutableState<String>,
    traceId: MutableState<String>,
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
                text = stringResource(id = R.string.tealium_ecommerce),
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
                    traceId = traceId,
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
                            tint = MaterialTheme.colors.onSurface,
                        )
                    }
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cart),
                        contentDescription = "Cart",
                        tint = MaterialTheme.colors.onSurface,
                    )
                }
            }
        }
    }
}

@Composable
private fun LoginDialog(
    openDialog: MutableState<Boolean>,
    emailAddress: MutableState<String>,
    traceId: MutableState<String>,
) {
    val emailVal = remember { mutableStateOf(emailAddress.value) }
    val passwordVal = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val traceVal = remember { mutableStateOf(traceId.value) }

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
                        text = stringResource(id = R.string.sign_in),
                        modifier = Modifier.fillMaxWidth(),
                        style = EcommTypography.subtitle1,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        textValue = stringResource(id = R.string.email_address),
                        bgColor = colorTextBodyLight,
                        stateValue = emailVal,
                        focusRequestN = focusRequesters[0],
                        focusRequestN1 = focusRequesters[1],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Email
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = stringResource(id = R.string.password),
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
                        textValue = stringResource(id = R.string.trace_id),
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
                            traceId.value = traceVal.value

                            ///////// Tealium Data ////////////
                            TealiumHelperList.currentTealiumHelper?.let { tealiumHelper ->

                                if(emailVal.value.isEmpty()){
                                    tealiumHelper.removeFromDataLayer(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        key = "email_address"
                                    )
                                }
                                else{
                                    tealiumHelper.setString2DataLayer(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        key = "email_address",
                                        value = emailVal.value,
                                    )
                                }

                                if(traceVal.value.isEmpty()){
                                    tealiumHelper.setString2DataLayer(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        key = "tealium_trace_id",
                                        value = emailVal.value,
                                    )

                                    tealiumHelper.leaveTrace(instanceName = TealiumHelperList.currentInstanceName!!)
                                }
                                else{
                                    tealiumHelper.setString2DataLayer(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        key = "tealium_trace_id",
                                        value = traceVal.value,
                                    )
                                }

                                tealiumHelper.trackEvent(
                                    instanceName = TealiumHelperList.currentInstanceName!!,
                                    name = "login_event",
                                    data = mapOf(),
                                )
                            }
                            //////////////////////////////////

                            openDialog.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusOrder(focusRequesters[3]) {
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.login) ,
                        )
                    }
                }

            }
        }
    }
}