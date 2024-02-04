package com.sametb.hoopsinsight.data.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sametb.hoopsinsight.data.local.db.PlayerDatabase
import com.sametb.hoopsinsight.data.paging_source.PlayerRemoteMediator
import com.sametb.hoopsinsight.data.paging_source.SearchPlayersSource
import com.sametb.hoopsinsight.data.remote.NBAApi
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.domain.repo.IRemoteDataSource
import com.sametb.hoopsinsight.util.constants.RemoteDataSourceConstants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query


/*
* Hoops Insight.com.sametb.hoopsinsight.data.repo
* Created by SAMET BAYAT 
* on 3.02.2024 at 12:45 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class RemoteDataSourceImpl(
    private val nbaApi: NBAApi,
    private val nbaDatabase: PlayerDatabase
): IRemoteDataSource {

    private val playerDao = nbaDatabase.playerDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllPlayers(): Flow<PagingData<Player>> {
        val pagingSourceFactory = { playerDao.getAllPlayers() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = PlayerRemoteMediator(nbaApi, nbaDatabase),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun searchPlayers(query: String): Flow<PagingData<Player>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = PlayerRemoteMediator(nbaApi, nbaDatabase),
            pagingSourceFactory = {
                SearchPlayersSource(nbaApi, query)
            }
        ).flow
    }
}