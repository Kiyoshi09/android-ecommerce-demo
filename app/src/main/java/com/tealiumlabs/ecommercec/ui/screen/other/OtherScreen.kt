package com.tealiumlabs.ecommercec.ui.screen.other

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
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
import com.tealiumlabs.ecommercec.data.prefsStore.readTealiumAccountSettings
import com.tealiumlabs.ecommercec.ui.screen.home.HomeScreenBottomBar
import com.tealiumlabs.ecommercec.model.EcommViewModel
import com.tealiumlabs.ecommercec.ui.screen.home.TealiumProfileConfigureDialog
import com.tealiumlabs.ecommercec.ui.theme.*

@Composable
fun OtherScreen(
    viewModel: EcommViewModel,
    navController: NavController,
) {
    val tealConfigStr =
        readTealiumAccountSettings(LocalContext.current).collectAsState(initial = ";;;").value
    val acct = tealConfigStr.split(";")[0]
    val prof = tealConfigStr.split(";")[1]
    val ds = tealConfigStr.split(";")[2]
    val env = tealConfigStr.split(";")[3]

    viewModel.tealiumAccount.value = acct
    viewModel.tealiumProfile.value = prof
    viewModel.tealiumDataSource.value = ds
    viewModel.tealiumEnvironment.value = env

    Scaffold(
        topBar = {
            OtherTopContent()
        },
        content = {
            OtherScreenContent(
                account = acct,
                profile = prof,
                dataSource = ds,
                environment = env,
                isOptIn = viewModel.isOptIn,
                consentAnalytics = viewModel.consentAnalytics,
                consentAffiliate = viewModel.consentAffiliate,
                consentDisplayAd = viewModel.consentDisplayAd,
                consentSearch = viewModel.consentSearch,
                consentEmail = viewModel.consentEmail,
                consentPersonalization = viewModel.consentPersonalization,
                consentSocial = viewModel.consentSocial,
                consentBigData = viewModel.consentBigData,
                consentMisc = viewModel.consentMisc,
                consentCookieMatch = viewModel.consentCookieMatch,
                consentCDP = viewModel.consentCDP,
                consentMobile = viewModel.consentMobile,
                consentEngagement = viewModel.consentEngagement,
                consentMonitoring = viewModel.consentMonitoring,
                consentCRM = viewModel.consentCRM,
            )
        },
        bottomBar = {
            HomeScreenBottomBar(
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
    account: String,
    profile: String,
    dataSource: String,
    environment: String,
    isOptIn: MutableState<Boolean>,
    consentAnalytics: MutableState<Boolean>,
    consentAffiliate: MutableState<Boolean>,
    consentDisplayAd: MutableState<Boolean>,
    consentSearch: MutableState<Boolean>,
    consentEmail: MutableState<Boolean>,
    consentPersonalization: MutableState<Boolean>,
    consentSocial: MutableState<Boolean>,
    consentBigData: MutableState<Boolean>,
    consentMisc: MutableState<Boolean>,
    consentCookieMatch: MutableState<Boolean>,
    consentCDP: MutableState<Boolean>,
    consentMobile: MutableState<Boolean>,
    consentEngagement: MutableState<Boolean>,
    consentMonitoring: MutableState<Boolean>,
    consentCRM: MutableState<Boolean>,
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
            text = "Tealium Account Configuration",
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
            Text(text = "Open Configuration Dialog")
        }

        if (openTealConfigDialog.value) {
            TealiumProfileConfigureDialog(
                openDialog = openTealConfigDialog,
                account = account,
                profile = profile,
                dataSource = dataSource,
                environment = environment,
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Video Tracking",
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
            text = "Consent Management",
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
            Text(text = "Consent Management Dialog")
        }

        if (openConsentMgrDialog.value) {
            ConsentMgrDialog(
                openDialog = openConsentMgrDialog,
                isOptIn = isOptIn,
                consentAnalytics = consentAnalytics,
                consentAffiliate = consentAffiliate,
                consentDisplayAd = consentDisplayAd,
                consentSearch = consentSearch,
                consentEmail = consentEmail,
                consentPersonalization = consentPersonalization,
                consentSocial = consentSocial,
                consentBigData = consentBigData,
                consentMisc = consentMisc,
                consentCookieMatch = consentCookieMatch,
                consentCDP = consentCDP,
                consentMobile = consentMobile,
                consentEngagement = consentEngagement,
                consentMonitoring = consentMonitoring,
                consentCRM = consentCRM,
            )
        }

        // Bottom
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConsentMgrDialog(
    openDialog: MutableState<Boolean>,
    isOptIn: MutableState<Boolean>,
    consentAnalytics: MutableState<Boolean>,
    consentAffiliate: MutableState<Boolean>,
    consentDisplayAd: MutableState<Boolean>,
    consentSearch: MutableState<Boolean>,
    consentEmail: MutableState<Boolean>,
    consentPersonalization: MutableState<Boolean>,
    consentSocial: MutableState<Boolean>,
    consentBigData: MutableState<Boolean>,
    consentMisc: MutableState<Boolean>,
    consentCookieMatch: MutableState<Boolean>,
    consentCDP: MutableState<Boolean>,
    consentMobile: MutableState<Boolean>,
    consentEngagement: MutableState<Boolean>,
    consentMonitoring: MutableState<Boolean>,
    consentCRM: MutableState<Boolean>,
) {
    val optInOut = remember { mutableStateOf(isOptIn.value) }
    val height1 = 680.dp
    val height2 = 170.dp

    val cAnalytics = remember { mutableStateOf(consentAnalytics.value) }
    val cAffiliate = remember { mutableStateOf(consentAffiliate.value) }
    val cDisplayAd = remember { mutableStateOf(consentDisplayAd.value) }
    val cSearch = remember { mutableStateOf(consentSearch.value) }
    val cEmail = remember { mutableStateOf(consentEmail.value) }
    val cPersonalization = remember { mutableStateOf(consentPersonalization.value) }
    val cSocial = remember { mutableStateOf(consentSocial.value) }
    val cBigData = remember { mutableStateOf(consentBigData.value) }
    val cMisc = remember { mutableStateOf(consentMisc.value) }
    val cCookieMatch = remember { mutableStateOf(consentCookieMatch.value) }
    val cCdp = remember { mutableStateOf(consentCDP.value) }
    val cMobile = remember { mutableStateOf(consentMobile.value) }
    val cEngagement = remember { mutableStateOf(consentEngagement.value) }
    val cMonitoring = remember { mutableStateOf(consentMonitoring.value) }
    val cCrm = remember { mutableStateOf(consentCRM.value) }

    val dialogHeight = remember {
        mutableStateOf(
            if (optInOut.value) {
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
                    text = "Consent Management",
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
                        text = "Consent Status",
                        modifier = Modifier
                            .weight(8f)
                    )

                    Switch(
                        modifier = Modifier
                            .weight(2f)
                            .padding(top = 8.dp),
                        checked = optInOut.value,
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
                            uiStatus = cAnalytics
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
                            isOptIn.value = optInOut.value
                            consentAnalytics.value = cAnalytics.value
                            consentAffiliate.value = cAffiliate.value
                            consentDisplayAd.value = cDisplayAd.value
                            consentSearch.value = cSearch.value
                            consentEmail.value = cEmail.value
                            consentPersonalization.value = cPersonalization.value
                            consentSocial.value = cSocial.value
                            consentBigData.value = cBigData.value
                            consentMisc.value = cMisc.value
                            consentCookieMatch.value = cCookieMatch.value
                            consentCDP.value = cCdp.value
                            consentMobile.value = cMobile.value
                            consentEngagement.value = cEngagement.value
                            consentMonitoring.value = cMonitoring.value
                            consentCRM.value = cCrm.value

                            openDialog.value = false
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(text = "Save")
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