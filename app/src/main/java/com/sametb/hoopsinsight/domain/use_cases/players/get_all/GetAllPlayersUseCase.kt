package com.sametb.hoopsinsight.domain.use_cases.players.get_all

import androidx.paging.PagingData
import com.sametb.hoopsinsight.data.repo.Repository
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import kotlinx.coroutines.flow.Flow


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.use_cases.players.get_all
* Created by SAMET BAYAT 
* on 3.02.2024 at 1:25 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class GetAllPlayersUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<PagingData<Player>> {
        return repository.getAllPlayers()
    }

}
