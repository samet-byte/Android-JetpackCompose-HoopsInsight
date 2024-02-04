package com.sametb.hoopsinsight.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sametb.hoopsinsight.data.local.converters.AwardConverter
import com.sametb.hoopsinsight.data.local.converters.DatabaseConverter
import com.sametb.hoopsinsight.data.local.converters.InfoConverter
import com.sametb.hoopsinsight.data.local.converters.IntConverter
import com.sametb.hoopsinsight.data.local.converters.StatsConverter
import com.sametb.hoopsinsight.data.local.dao.PlayerDao
import com.sametb.hoopsinsight.data.local.dao.PlayerRemoteKeysDao
import com.sametb.hoopsinsight.domain.model.player_paging.PlayerRemoteKeys
import com.sametb.hoopsinsight.domain.model.player_paging.Player


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local
* Created by SAMET BAYAT 
* on 1.02.2024 at 5:20 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Database(
    entities = [
        Player::class,
        PlayerRemoteKeys::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(
    InfoConverter::class,
    StatsConverter::class,
    AwardConverter::class,
    DatabaseConverter::class,
    IntConverter::class
)
abstract class PlayerDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    abstract fun playerRemoteKeysDao(): PlayerRemoteKeysDao
}