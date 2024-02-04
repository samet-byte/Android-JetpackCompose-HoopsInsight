package com.sametb.hoopsinsight.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sametb.hoopsinsight.data.remote.NBAApi
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.data.paging_source
* Created by SAMET BAYAT 
* on 4.02.2024 at 2:29 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class SearchPlayersSource
    @Inject constructor(
        private val nbaApi: NBAApi,
        private val query: String

    ): PagingSource<Int, Player>(){
    override fun getRefreshKey(state: PagingState<Int, Player>): Int? {
        return state.anchorPosition // returns most recent page key, or null if no anchor position
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Player> {
        try {
            val apiResponse = nbaApi.searchPlayers(name = query)
            val players = apiResponse.players
            return if (players.isNotEmpty()){
                LoadResult.Page(
                    data = players,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        }catch (e: Exception){
            return LoadResult.Error(e)
        }
    }
}