package com.tealiumlabs.ecommercec.ui.screen.other

import android.app.Application
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.DataUsage
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.tealium.core.consent.ConsentCategory
import com.tealium.core.consent.ConsentStatus
import com.tealiumlabs.ecommercec.R
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.tealium.TealiumHelperList
import com.tealiumlabs.ecommercec.ui.components.CustomTextField
import com.tealiumlabs.ecommercec.ui.components.ScreenBottomBar
import com.tealiumlabs.ecommercec.ui.theme.*
import com.tealiumlabs.ecommercec.utils.RequestState

@Composable
fun OtherScreen(
    viewModel: EcommViewModel,
    navController: NavController,
) {
    /////////// TEALIUM TRACKING /////////////
    LaunchedEffect(key1 = TealiumHelperList.currentInstanceName){
        TealiumHelperList.currentTealiumHelper?.let { tealiumHelper ->

            Log.d("KIYOSHI-TEALIUM-TRACKING", "other")

            tealiumHelper.trackView(
                instanceName = TealiumHelperList.currentInstanceName!!,
                name = "screen_view",
                data = mutableMapOf(
                    "screen_name" to "other",
                    "screen_type" to "other",
                )
            )
        }
    }
    //////////////////////////////////////////

    val tealiumConfigState by viewModel.tealiumConfigState.collectAsState()
    Log.d("KIYOSHI-TEALIUM_CONFIG", "config - OtherScreen : ${tealiumConfigState.toString()}")

    Scaffold(
        topBar = {
            OtherTopContent()
        },
        content = {
            OtherScreenContent(
                viewModel = viewModel,
                tealiumConfigState = tealiumConfigState,
            )
        },
        bottomBar = {
            ScreenBottomBar(
                navController = navController
            )
        }
    )
}

@Composable
private fun OtherTopContent() {
    Row(
        Modifier
            .background(veryLighGray)
            .padding(bottom = 12.dp)
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
        }

        Column(
            modifier = Modifier.weight(1.5f),
            horizontalAlignment = Alignment.Start
        ) {
        }
    }

}

@Composable
private fun OtherScreenContent(
    viewModel: EcommViewModel,
    tealiumConfigState: RequestState<String>,
) {
    val openTealConfigDialog = remember { mutableStateOf(false) }
    val openConsentMgrDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = R.string.tealium_account_configuration),
            style = EcommTypography.h5,
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            thickness = 1.dp,
            startIndent = 0.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                openTealConfigDialog.value = true
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(4.dp)
                .clip(RoundedCornerShape(5.dp))
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.open_configuration_dialog))
        }

        if (openTealConfigDialog.value) {
            TealiumProfileConfigureDialog(
                openDialog = openTealConfigDialog,
                onSaveClicked = {
                    viewModel.persistTealiumConfigState(it)
                },
                tealiumConfigState = tealiumConfigState,
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(id = R.string.video_tracking),
            style = EcommTypography.h5,
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            thickness = 1.dp,
            startIndent = 0.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            val context = LocalContext.current
            val url =
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

            val exoPlayer = remember(context) {

                ExoPlayer.Builder(context).build().apply {
                    val dataSourceFactor: DataSource.Factory = DefaultDataSource.Factory(context)
                    val source = ProgressiveMediaSource.Factory(dataSourceFactor)
                        .createMediaSource(MediaItem.fromUri(url))

                    this.prepare(source)
                }
            }

            AndroidView(
                factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(id = R.string.consent_management),
            style = EcommTypography.h5,
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            thickness = 1.dp,
            startIndent = 0.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                openConsentMgrDialog.value = true
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(4.dp)
                .clip(RoundedCornerShape(5.dp))
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.consent_management_dialog))
        }

        if (openConsentMgrDialog.value) {
            ConsentMgrDialog(
                viewModel = viewModel,
                openDialog = openConsentMgrDialog,
            )
        }

        // Bottom
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConsentMgrDialog(
    viewModel: EcommViewModel,
    openDialog: MutableState<Boolean>,
) {
    val optInOut = remember { viewModel.isOptIn }
    val height1 = 680.dp
    val height2 = 170.dp

    val cAnalytics = remember { viewModel.consentAnalytics }
    val cAffiliate = remember { viewModel.consentAffiliate }
    val cDisplayAd = remember { viewModel.consentDisplayAd }
    val cSearch = remember { viewModel.consentSearch }
    val cEmail = remember { viewModel.consentEmail }
    val cPersonalization = remember { viewModel.consentPersonalization }
    val cSocial = remember { viewModel.consentSocial }
    val cBigData = remember { viewModel.consentBigData }
    val cMisc = remember { viewModel.consentMisc }
    val cCookieMatch = remember { viewModel.consentCookieMatch }
    val cCdp = remember { viewModel.consentCDP }
    val cMobile = remember { viewModel.consentMobile }
    val cEngagement = remember { viewModel.consentEngagement }
    val cMonitoring = remember { viewModel.consentMonitoring }
    val cCrm = remember { viewModel.consentCRM }

    val dialogHeight = remember {
        mutableStateOf(
            if (viewModel.isOptIn.value) {
                height1
            } else {
                height2
            }
        )
    }

    Dialog(
        onDismissRequest = { openDialog.value = false },
        DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(dialogHeight.value)
                .clip(RoundedCornerShape(5.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = stringResource(id = R.string.consent_management),
                    style = EcommTypography.h5,
                )

                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray,
                    thickness = 1.dp,
                    startIndent = 0.dp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.consent_status),
                        modifier = Modifier
                            .weight(8f)
                    )

                    Switch(
                        modifier = Modifier
                            .weight(2f)
                            .padding(top = 8.dp),
                        checked = viewModel.isOptIn.value,
                        onCheckedChange = {
                            optInOut.value = it

                            if (optInOut.value) {
                                dialogHeight.value = height1
                            } else {
                                dialogHeight.value = height2
                            }
                        }
                    )
                }

                if (optInOut.value) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Preferences",
                            style = EcommTypography.h5.copy(fontSize = 12.sp),
                        )

                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.LightGray,
                            thickness = 1.dp,
                            startIndent = 0.dp
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Analytics",
                            uiStatus = cAnalytics,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Affiliate",
                            uiStatus = cAffiliate,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Display Ad",
                            uiStatus = cDisplayAd,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Search",
                            uiStatus = cSearch,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Email",
                            uiStatus = cEmail,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Personalization",
                            uiStatus = cPersonalization,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Social",
                            uiStatus = cSocial,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Big Data",
                            uiStatus = cBigData,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Misc",
                            uiStatus = cMisc,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Cookie Match",
                            uiStatus = cCookieMatch,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "CDP",
                            uiStatus = cCdp,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Mobile",
                            uiStatus = cMobile,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Engagement",
                            uiStatus = cEngagement,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "Monitoring",
                            uiStatus = cMonitoring,
                        )

                        ConsentPreferenceCategory(
                            categoryName = "CRM",
                            uiStatus = cCrm,
                        )

                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Button(
                        onClick = {
                            viewModel.isOptIn.value = optInOut.value
                            viewModel.consentAnalytics.value = cAnalytics.value
                            viewModel.consentAffiliate.value = cAffiliate.value
                            viewModel.consentDisplayAd.value = cDisplayAd.value
                            viewModel.consentSearch.value = cSearch.value
                            viewModel.consentEmail.value = cEmail.value
                            viewModel.consentPersonalization.value = cPersonalization.value
                            viewModel.consentSocial.value = cSocial.value
                            viewModel.consentBigData.value = cBigData.value
                            viewModel.consentMisc.value = cMisc.value
                            viewModel.consentCookieMatch.value = cCookieMatch.value
                            viewModel.consentCDP.value = cCdp.value
                            viewModel.consentMobile.value = cMobile.value
                            viewModel.consentEngagement.value = cEngagement.value
                            viewModel.consentMonitoring.value = cMonitoring.value
                            viewModel.consentCRM.value = cCrm.value

                            TealiumHelperList.currentTealiumHelper?.let { tealiumHelper ->
                                if (optInOut.value) {
                                    tealiumHelper.setConsentStatus(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        status = ConsentStatus.CONSENTED,
                                    )

                                    val consentedCategories = mutableSetOf<ConsentCategory>()
                                    if(cAnalytics.value) consentedCategories.add(ConsentCategory.ANALYTICS)
                                    if(cAffiliate.value) consentedCategories.add(ConsentCategory.AFFILIATES)
                                    if(cDisplayAd.value) consentedCategories.add(ConsentCategory.DISPLAY_ADS)
                                    if(cSearch.value) consentedCategories.add(ConsentCategory.SEARCH)
                                    if(cEmail.value) consentedCategories.add(ConsentCategory.EMAIL)
                                    if(cPersonalization.value) consentedCategories.add(ConsentCategory.PERSONALIZATION)
                                    if(cSocial.value) consentedCategories.add(ConsentCategory.SOCIAL)
                                    if(cBigData.value) consentedCategories.add(ConsentCategory.BIG_DATA)
                                    if(cMisc.value) consentedCategories.add(ConsentCategory.MISC)
                                    if(cCdp.value) consentedCategories.add(ConsentCategory.CDP)
                                    if(cMobile.value) consentedCategories.add(ConsentCategory.MOBILE)
                                    if(cEngagement.value) consentedCategories.add(ConsentCategory.ENGAGEMENT)
                                    if(cMonitoring.value) consentedCategories.add(ConsentCategory.MONITORING)
                                    if(cCrm.value) consentedCategories.add(ConsentCategory.CRM)

                                    tealiumHelper.setConsentCategories(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        categories = consentedCategories,
                                    )

                                } else {
                                    tealiumHelper.setConsentStatus(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        status = ConsentStatus.NOT_CONSENTED,
                                    )

                                    tealiumHelper.setConsentCategories(
                                        instanceName = TealiumHelperList.currentInstanceName!!,
                                        categories = setOf(),
                                    )
                                }
                            }

                            openDialog.value = false
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(text = stringResource(id = R.string.save))
                    }
                }
            }
        }
    }
}

@Composable
private fun ConsentPreferenceCategory(
    categoryName: String,
    uiStatus: MutableState<Boolean>,
) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = categoryName,
            modifier = Modifier
                .weight(8f),
            fontSize = 14.sp,
        )

        Switch(
            modifier = Modifier
                .weight(2f)
                .padding(top = 8.dp),
            checked = uiStatus.value,
            onCheckedChange = {
                uiStatus.value = it
            }
        )
    }
}

@Composable
private fun TealiumProfileConfigureDialog(
    openDialog: MutableState<Boolean>,
    onSaveClicked: (String) -> Unit,
    tealiumConfigState: RequestState<String>,
) {
    val acct = remember { mutableStateOf("") }
    val prof = remember { mutableStateOf("") }
    val ds = remember { mutableStateOf("") }
    val env = remember { mutableStateOf("") }

    if (tealiumConfigState is RequestState.Success) {
        val s = tealiumConfigState.data

        if (s.contains(";")
            && s.split(";").size == 4
        ) {

            acct.value = s.split(";")[0]
            prof.value = s.split(";")[1]
            ds.value = s.split(";")[2]
            env.value = s.split(";")[3]
        }
    }

    val focusRequesters = List(6) { FocusRequester() }
    val context = LocalContext.current

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
                        text = stringResource(id = R.string.tealium_account_information),
                        modifier = Modifier.fillMaxWidth(),
                        style = EcommTypography.subtitle1.copy(fontSize = 16.sp),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        textValue = stringResource(id = R.string.account),
                        bgColor = colorTextBodyLight,
                        stateValue = acct,
                        focusRequestN = focusRequesters[0],
                        focusRequestN1 = focusRequesters[1],
                        fontSize = 16.sp,
                        icon = Icons.Filled.AccountBox,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = stringResource(id = R.string.profile),
                        bgColor = colorTextBodyLight,
                        stateValue = prof,
                        focusRequestN = focusRequesters[1],
                        focusRequestN1 = focusRequesters[2],
                        fontSize = 16.sp,
                        icon = Icons.Filled.Campaign,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = stringResource(id = R.string.data_source),
                        bgColor = colorTextBodyLight,
                        stateValue = ds,
                        focusRequestN = focusRequesters[2],
                        focusRequestN1 = focusRequesters[3],
                        fontSize = 16.sp,
                        icon = Icons.Filled.DataUsage,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomTextField(
                        textValue = stringResource(id = R.string.environment),
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
                            Text(stringResource(id = R.string.clear))
                        }

                        Button(
                            onClick = {
                                val tealConfigStr =
                                    "${acct.value};${prof.value};${ds.value};${env.value}"

                                onSaveClicked(tealConfigStr)
                                TealiumHelperList.update(
                                    application = context.applicationContext as Application,
                                    name = tealConfigStr,
                                )

                                openDialog.value = false
                            },
                            modifier = Modifier
                                .weight(0.5f)
                                .padding(4.dp)
                                .focusOrder(focusRequesters[5]) {
                                }
                        ) {
                            Text(stringResource(id = R.string.save))
                        }

                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
        }
    }
}
