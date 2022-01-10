package com.tealiumlabs.ecommercec.tealium

import android.app.Application
import android.util.Log
import com.tealium.collectdispatcher.Collect
import com.tealium.core.*
import com.tealium.core.consent.*
import com.tealium.core.events.EventTrigger
import com.tealium.core.messaging.UserConsentPreferencesUpdatedListener
import com.tealium.core.validation.DispatchValidator
import com.tealium.crashreporter.CrashReporter
import com.tealium.dispatcher.Dispatch
import com.tealium.dispatcher.TealiumEvent
import com.tealium.dispatcher.TealiumView
import com.tealium.lifecycle.Lifecycle
import com.tealium.media.Media
import com.tealium.media.mediaBackgroundSessionEnabled
import com.tealium.media.mediaBackgroundSessionEndInterval
import com.tealium.remotecommanddispatcher.RemoteCommands
import com.tealium.remotecommanddispatcher.remoteCommands
import com.tealium.remotecommands.RemoteCommand
import com.tealium.tagmanagementdispatcher.TagManagement
import com.tealium.visitorservice.VisitorProfile
import com.tealium.visitorservice.VisitorService
import com.tealium.visitorservice.VisitorUpdatedListener
import com.tealiumlabs.ecommercec.BuildConfig.TAG
import com.tealiumlabs.ecommercec.BuildConfig.TEALIUM_INSTANCE
import java.util.concurrent.TimeUnit

object TealiumHelper {

    fun init(
        application: Application,
        accountName: String = "tealiummobile",
        profileName: String = "android",
        envName: String = "dev",
        dataSourceId: String = "",
    ) {
        Log.d("KIYOSHI-TEALIUM", "$accountName,$profileName,$envName,$dataSourceId")

        val config = TealiumConfig(
            application,
            accountName = accountName,
            profileName = profileName,
            environment = if (envName.lowercase() == "prod") Environment.PROD else if (envName.lowercase() == "qa") Environment.QA else Environment.DEV,
            dataSourceId = dataSourceId,
            modules = mutableSetOf(
                Lifecycle,
                VisitorService,
                //Modules.HostedDataLayer,
                CrashReporter,
                //AdIdentifier,
                //Modules.AutoTracking,
                Media
            ),
            dispatchers = mutableSetOf(
                Dispatchers.Collect,
                Dispatchers.TagManagement,
                Dispatchers.RemoteCommands
            )
        ).apply {
            useRemoteLibrarySettings = true
            //hostedDataLayerEventMappings = mapOf("pdp" to "product_id")
            // Uncomment one of the following lines to set the appropriate Consent Policy
            // and enable the consent manager
            consentManagerPolicy = ConsentPolicy.GDPR
            // consentManagerPolicy = ConsentPolicy.CCPA
            consentExpiry = ConsentExpiry(1, TimeUnit.DAYS)

            timedEventTriggers = mutableListOf(
                EventTrigger.forEventName("start_event", "end_event")
            )

            mediaBackgroundSessionEnabled = false
            mediaBackgroundSessionEndInterval = 5000L  // end session after 5 seconds

            //autoTrackingMode = if (BuildConfig.AUTO_TRACKING) AutoTrackingMode.FULL else AutoTrackingMode.NONE
            // autoTrackingBlocklistFilename = "autotracking-blocklist.json"
            // autoTrackingBlocklistUrl = "https://tags.tiqcdn.com/dle/tealiummobile/android/autotracking-blocklist.json"
            //autoTrackingCollectorDelegate = TealiumHelper
        }

        Tealium.create(TEALIUM_INSTANCE, config) {
            events.subscribe(object : UserConsentPreferencesUpdatedListener {
                override fun onUserConsentPreferencesUpdated(
                    userConsentPreferences: UserConsentPreferences,
                    policy: ConsentManagementPolicy
                ) {
                    if (userConsentPreferences.consentStatus == ConsentStatus.UNKNOWN) {
                        Logger.dev(TAG, "Re-prompt for consent")
                    }
                }
            })

            events.subscribe(object : VisitorUpdatedListener {
                override fun onVisitorUpdated(visitorProfile: VisitorProfile) {
                    Logger.dev("--", "did update vp with $visitorProfile")
                }
            })

            remoteCommands?.add(localJsonCommand, filename = "remoteCommand.json")
            remoteCommands?.add(webViewRemoteCommand)
        }
    }

    val webViewRemoteCommand = object : RemoteCommand("bgcolor", "testing Webview RCs") {
        override fun onInvoke(response: Response) {
            Logger.dev(TAG, "ResponsePayload for webView RemoteCommand ${response.requestPayload}")
        }
    }

    val localJsonCommand = object : RemoteCommand("localJsonCommand", "testingRCs") {
        override fun onInvoke(response: Response) {
            Logger.dev(
                TAG,
                "ResponsePayload for local JSON RemoteCommand ${response.requestPayload}"
            )
        }
    }

    fun fetchConsentCategories(): String? {
        return Tealium[TEALIUM_INSTANCE]?.consentManager?.userConsentCategories?.joinToString(",")
    }

    fun setConsentCategories(categories: Set<String>) {
        Tealium[TEALIUM_INSTANCE]?.consentManager?.userConsentCategories =
            ConsentCategory.consentCategories(categories)
    }

    fun trackView(name: String, data: Map<String, Any>?) {
        val viewDispatch = TealiumView(name, data)
        Tealium[TEALIUM_INSTANCE]?.track(viewDispatch)
    }

    fun trackEvent(name: String, data: Map<String, Any>?) {
        val eventDispatch = TealiumEvent(name, data)
        Tealium[TEALIUM_INSTANCE]?.track(eventDispatch)
    }

    val customValidator: DispatchValidator by lazy {
        object : DispatchValidator {
            override fun shouldQueue(dispatch: Dispatch?): Boolean {
                Logger.dev(TAG, "shouldQueue: CustomValidator")
                return false
            }

            override fun shouldDrop(dispatch: Dispatch): Boolean {
                Logger.dev(TAG, "shouldDrop: CustomValidator")
                return false
            }

            override val name: String = "my validator"
            override var enabled: Boolean = true
        }
    }

    fun onCollectActivityData(activityName: String): Map<String, Any>? {
        return mapOf("global_data" to "value")
    }

}