package com.tealiumlabs.ecommercec

import android.app.Application
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.tealium.core.Tealium
import com.tealiumlabs.ecommercec.data.prefsStore.readTealiumAccountSettings
import com.tealiumlabs.ecommercec.tealium.TealiumHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EcommApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}