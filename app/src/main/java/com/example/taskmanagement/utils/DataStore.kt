package com.example.azureexp.utils

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "user_preferences")

object UserPreferenceKeys {
    //userdata type preference
    val USER_ID = stringPreferencesKey("user_id")
    val BOARD_ID = stringPreferencesKey("board_id")
}