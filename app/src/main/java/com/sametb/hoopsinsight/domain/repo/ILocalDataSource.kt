package com.sametb.hoopsinsight.domain.repo

import com.sametb.hoopsinsight.domain.model.player_paging.Player


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.repo
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:39 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

interface ILocalDataSource {
    suspend fun getSelectedPlayer(id: Int): Player
}