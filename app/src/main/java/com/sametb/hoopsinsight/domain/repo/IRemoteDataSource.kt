package com.sametb.hoopsinsight.domain.repo

import androidx.paging.PagingData
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import kotlinx.coroutines.flow.Flow


/*
* Hoops Insight.com.sametb.hoopsinsight.repo
* Created by SAMET BAYAT 
* on 3.02.2024 at 12:27 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

interface IRemoteDataSource {

    fun getAllPlayers(): Flow<PagingData<Player>>

    fun searchPlayers(query: String): Flow<PagingData<Player>>
}