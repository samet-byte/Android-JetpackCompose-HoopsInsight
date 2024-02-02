package com.sametb.hoopsinsight.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.sametb.hoopsinsight.repo.IDataStoreOperations
import com.sametb.hoopsinsight.util.constants.DataStoreConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.preferences
* Created by SAMET BAYAT 
* on 2.02.2024 at 4:21 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DataStoreConstants.PREFERENCES_NAME)
class DataOperationsImpl(
    context: Context
): IDataStoreOperations {

    private object PrefsKey {
        val onBoardingKey = booleanPreferencesKey(DataStoreConstants.PREFERENCES_COMPLETED_KEY)
    }

    private val dataStore = context.dataStore // instance of DataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PrefsKey.onBoardingKey] = completed
        }
    }
    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                val isOnBoardingCompleted = preferences[PrefsKey.onBoardingKey] ?: false
                isOnBoardingCompleted
            }
    }
}