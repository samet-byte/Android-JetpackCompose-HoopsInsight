package com.sametb.hoopsinsight.data.repo

import com.sametb.hoopsinsight.data.local.db.PlayerDatabase
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.domain.repo.ILocalDataSource


/*
* Hoops Insight.com.sametb.hoopsinsight.data.repo
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:40 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class DataSourceImpl(
    playerDatabase: PlayerDatabase
): ILocalDataSource {

    private val playerDao = playerDatabase.playerDao()
    override suspend fun getSelectedPlayer(id: Int): Player {
        return playerDao.getSelectedPlayer(id = id)
    }
}