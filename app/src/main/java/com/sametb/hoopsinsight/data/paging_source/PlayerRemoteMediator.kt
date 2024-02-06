package com.sametb.hoopsinsight.data.paging_source

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.sametb.hoopsinsight.data.local.db.PlayerDatabase
import com.sametb.hoopsinsight.data.remote.NBAApi
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.domain.model.player_paging.PlayerRemoteKeys
import com.sametb.hoopsinsight.util.constants.CacheConstants
import com.sametb.hoopsinsight.util.constants.CacheConstants.CACHE_TIMEOUT
import com.sametb.hoopsinsight.util.constants.CacheConstants.differenceInMinutes
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.paging_source
* Created by SAMET BAYAT 
* on 2.02.2024 at 11:01 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@OptIn(ExperimentalPagingApi::class)
class PlayerRemoteMediator
    @Inject constructor(
        private val nbaApi: NBAApi,
        private val nbaDatabase: PlayerDatabase
    ) : RemoteMediator<Int, Player>(){

        private val playerDao = nbaDatabase.playerDao()
        private val playerRemoteKeysDao = nbaDatabase.playerRemoteKeysDao()
    private suspend fun getClosestRemoteKeyToCurrentPosition(state: PagingState<Int, Player>): PlayerRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id -> // allows not just id, for our case it is id
                playerRemoteKeysDao.getRemoteKeys(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Player>): PlayerRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { player ->
            playerRemoteKeysDao.getRemoteKeys(player.id)
        }

    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Player>): PlayerRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { player ->
            playerRemoteKeysDao.getRemoteKeys(player.id)
        }

    }

    @SuppressLint("SimpleDateFormat")
    private fun parseMillisToDate(millis: Long): String {
        return java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Date(millis))
    }

    override suspend fun initialize(): InitializeAction {
        val currentTimestamp = System.currentTimeMillis()
        val lastUpdated = playerRemoteKeysDao.getRemoteKeys(id = 1)?.lastUpdated ?: 0L

//        Log.d(CacheConstants.LogTags.PLAYER_REMOTE_MEDIATOR, "initialize: currentTimestamp: ${parseMillisToDate(currentTimestamp)}")
//        Log.d(CacheConstants.LogTags.PLAYER_REMOTE_MEDIATOR, "initialize: lastUpdated: ${parseMillisToDate(lastUpdated)}")
//        log expiration time
//        Log.d(CacheConstants.LogTags.PLAYER_REMOTE_MEDIATOR, "initialize: CACHE_TIMEOUT: ${parseMillisToDate(currentTimestamp + CACHE_TIMEOUT * 60 * 1000)}")


        return if (differenceInMinutes(currentTimestamp, lastUpdated) <= CACHE_TIMEOUT) {
//            Log.d(CacheConstants.LogTags.PLAYER_REMOTE_MEDIATOR, "initialize: UP TO DATE, SKIP INITIAL REFRESH")
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
//            Log.d(CacheConstants.LogTags.PLAYER_REMOTE_MEDIATOR, "initialize: REFRESHING, LAUNCH INITIAL REFRESH")
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Player>): MediatorResult {
            return try {

                val page = when(loadType) {
                    LoadType.REFRESH -> { // refresh, run for the first time
                        val remoteKeys = getClosestRemoteKeyToCurrentPosition(state)
                        remoteKeys?.nextPage?.minus(1) ?: 1
                    }
                    LoadType.PREPEND -> {
                        val remoteKeys = getRemoteKeyForFirstItem(state)
                        val prevKey = remoteKeys?.prevPage
                            ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                        prevKey
                    }
                    LoadType.APPEND -> {
                        val remoteKeys = getRemoteKeyForLastItem(state)
                        val nextPage = remoteKeys?.nextPage
                            ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                        nextPage
                    }
                }


                val response = nbaApi.getAllPlayers(page = page)
                if (response.players.isNotEmpty()) {
                    nbaDatabase.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            playerDao.deleteAllPlayers()
                            playerRemoteKeysDao.deleteAllRemoteKeys()
                        }
                        val prevPage = response.prevPage
                        val nextPage = response.nextPage
                        val keys = response.players.map { player ->
                            PlayerRemoteKeys(
                                id = player.id,
                                prevPage = prevPage,
                                nextPage = nextPage,
                                lastUpdated = response.lastUpdated
                            )
                        }
                        playerRemoteKeysDao.addAllRemoteKeys(keys)
                        playerDao.addPlayers(players = response.players)
                    }
                }
                // if next page is null, we reached the end of the list
                MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
            } catch (e: Exception) {
                return MediatorResult.Error(e)
            }
        }

}