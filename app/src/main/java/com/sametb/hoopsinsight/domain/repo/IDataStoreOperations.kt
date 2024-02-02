package com.sametb.hoopsinsight.domain.repo

import kotlinx.coroutines.flow.Flow


/*
* Hoops Insight.com.sametb.hoopsinsight.repo
* Created by SAMET BAYAT 
* on 2.02.2024 at 3:41 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

interface IDataStoreOperations {
    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}