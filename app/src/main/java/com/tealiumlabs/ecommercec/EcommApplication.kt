package com.tealiumlabs.ecommercec

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EcommApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}