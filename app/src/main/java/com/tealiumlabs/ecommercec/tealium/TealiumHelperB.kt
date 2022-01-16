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
import com.tealium.lifecycle.isAutoTrackingEnabled
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
import com.tealiumlabs.ecommercec.BuildConfig
import java.util.concurrent.TimeUnit

class TealiumHelperB(
    val application: Application,
    val name: String,
    val accountName: String,
    val profileName: String,
    val envName: String,
    val dataSourceId: String,
) {
    fun init() {
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

            // Commented out for test
            consentManagerPolicy = ConsentPolicy.GDPR
            // consentManagerPolicy = ConsentPolicy.CCPA
            consentExpiry = ConsentExpiry(1, TimeUnit.DAYS)

            timedEventTriggers = mutableListOf(
                EventTrigger.forEventName("start_event", "end_event")
            )

            mediaBackgroundSessionEnabled = false
            mediaBackgroundSessionEndInterval = 5000L  // end session after 5 seconds

            isAutoTrackingEnabled = true

            //autoTrackingMode = if (BuildConfig.AUTO_TRACKING) AutoTrackingMode.FULL else AutoTrackingMode.NONE
            // autoTrackingBlocklistFilename = "autotracking-blocklist.json"
            // autoTrackingBlocklistUrl = "https://tags.tiqcdn.com/dle/tealiummobile/android/autotracking-blocklist.json"
            //autoTrackingCollectorDelegate = TealiumHelper
        }

        Tealium.create(name, config) {

            this.consentManager.isConsentLoggingEnabled = true

            events.subscribe(object : UserConsentPreferencesUpdatedListener {
                override fun onUserConsentPreferencesUpdated(
                    userConsentPreferences: UserConsentPreferences,
                    policy: ConsentManagementPolicy
                ) {
                    Log.d("KIYOSHI-CONSENT", "call onUserConsentPreferencesUpdated ${userConsentPreferences.consentStatus}")

                    if (userConsentPreferences.consentStatus == ConsentStatus.UNKNOWN) {
                        Logger.dev(BuildConfig.TAG, "Re-prompt for consent")
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
            Logger.dev(BuildConfig.TAG, "ResponsePayload for webView RemoteCommand ${response.requestPayload}")
        }
    }

    val localJsonCommand = object : RemoteCommand("localJsonCommand", "testingRCs") {
        override fun onInvoke(response: Response) {
            Logger.dev(
                BuildConfig.TAG,
                "ResponsePayload for local JSON RemoteCommand ${response.requestPayload}"
            )
        }
    }

    fun fetchConsentCategories(instanceName:String): String? {
        return Tealium[instanceName]?.consentManager?.userConsentCategories?.joinToString(",")
    }

    fun setConsentStatus(instanceName:String, status: ConsentStatus) {
        Tealium[instanceName]?.consentManager?.userConsentStatus = status
    }

    fun getConsentStatus(instanceName: String): Boolean {
        return Tealium[instanceName]?.consentManager?.userConsentStatus == ConsentStatus.CONSENTED
    }

    fun setConsentCategories(instanceName:String, categories: Set<ConsentCategory>) {
        Tealium[instanceName]?.consentManager?.userConsentCategories = categories
    }

//    fun setConsentCategories(instanceName:String, categories: Set<String>) {
//        Tealium[instanceName]?.consentManager?.userConsentCategories =
//            ConsentCategory.consentCategories(categories)
//    }

    fun trackView(instanceName:String, name: String, data: Map<String, Any>?) {
        val viewDispatch = TealiumView(name, data)
        Tealium[instanceName]?.track(viewDispatch)
    }

    fun trackEvent(instanceName:String, name: String, data: Map<String, Any>?) {
        val eventDispatch = TealiumEvent(name, data)
        Tealium[instanceName]?.track(eventDispatch)
    }

    val customValidator: DispatchValidator by lazy {
        object : DispatchValidator {
            override fun shouldQueue(dispatch: Dispatch?): Boolean {
                Logger.dev(BuildConfig.TAG, "shouldQueue: CustomValidator")
                return false
            }

            override fun shouldDrop(dispatch: Dispatch): Boolean {
                Logger.dev(BuildConfig.TAG, "shouldDrop: CustomValidator")
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