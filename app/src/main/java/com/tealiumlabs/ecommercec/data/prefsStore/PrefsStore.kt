package com.tealiumlabs.ecommercec.data.prefsStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "tealium_settings")

fun readTealiumAccountSettings(context: Context): Flow<String> {
    val TEAL_CONFIG = stringPreferencesKey("tealium_account_config")
    val tealAccountConfigFlow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[TEAL_CONFIG] ?: ";;;"
        }

    return tealAccountConfigFlow
}

suspend fun saveTealiumAccountSettings(context: Context, tealConfig: String) {
    val TEAL_CONFIG = stringPreferencesKey("tealium_account_config")
    context.dataStore.edit { settings ->
        settings[TEAL_CONFIG] = tealConfig
    }
}
