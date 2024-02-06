package com.sametb.hoopsinsight.data.repo


import androidx.paging.PagingData
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.domain.repo.IDataStoreOperations
import com.sametb.hoopsinsight.domain.repo.ILocalDataSource
import com.sametb.hoopsinsight.domain.repo.IRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.repo
* Created by SAMET BAYAT 
* on 2.02.2024 at 5:19 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class Repository @Inject constructor(
    private val remote: IRemoteDataSource,
    private val dataStore: IDataStoreOperations,
    private val local: ILocalDataSource
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    fun getAllPlayers(): Flow<PagingData<Player>> {
        return remote.getAllPlayers()
    }

    fun searchPlayers(query: String): Flow<PagingData<Player>> {
        return remote.searchPlayers(query = query)
    }

    suspend fun getSelectedPlayer(id: Int): Player {
        return local.getSelectedPlayer(id = id)
    }

}