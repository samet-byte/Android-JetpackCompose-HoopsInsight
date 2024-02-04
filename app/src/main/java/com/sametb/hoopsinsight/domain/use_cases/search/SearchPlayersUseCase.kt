package com.sametb.hoopsinsight.domain.use_cases.search

import androidx.paging.PagingData
import com.sametb.hoopsinsight.data.repo.Repository
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import kotlinx.coroutines.flow.Flow


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.use_cases.search
* Created by SAMET BAYAT 
* on 4.02.2024 at 3:13 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class SearchPlayersUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Player>>
            = repository.searchPlayers(query = query)
}