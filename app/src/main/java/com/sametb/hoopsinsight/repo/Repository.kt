package com.sametb.hoopsinsight.repo


import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.repo
* Created by SAMET BAYAT 
* on 2.02.2024 at 5:19 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class Repository @Inject constructor(
    private val dataStore: IDataStoreOperations
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }


}