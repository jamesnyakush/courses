package com.jnyakush.course.utils

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(
    context: Context
) {
    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "user_store"
        )
    }

    val authToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_AUTH] ?: ""
        }

    val fetchStudentId: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[STUDENT_ID]
        }

    suspend fun saveStudentId(id: String) {
        dataStore.edit { preferences ->

            preferences[STUDENT_ID] = id
        }
    }

    suspend fun saveAuthToken(authToken: String) {
        dataStore.edit { preferences ->
            preferences[KEY_AUTH] = authToken
        }
    }

    suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val KEY_AUTH = preferencesKey<String>("key_auth")
        private val STUDENT_ID = preferencesKey<String>("student_id")
    }

}