package com.example.azureexp.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val context: Context) {
    val userID : Flow<String?>
        get() = context.dataStore.data.map { preferences ->
            preferences[UserPreferenceKeys.USER_ID]
        }

    val boardId : Flow<String?>
        get() = context.dataStore.data.map { preferences ->
            preferences[UserPreferenceKeys.BOARD_ID]
        }


    suspend fun setUserID(userId: String) {
        context.dataStore.edit { preferences ->
            preferences[UserPreferenceKeys.USER_ID] = userId
        }
    }

    suspend fun setBoardID(boardId: String) {
        context.dataStore.edit { preferences ->
            preferences[UserPreferenceKeys.BOARD_ID] = boardId
        }
    }


}