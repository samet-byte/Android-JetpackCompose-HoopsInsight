package com.sametb.hoopsinsight.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sametb.hoopsinsight.data.local.dao.PlayerDao
import com.sametb.hoopsinsight.domain.model.player.Player


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local
* Created by SAMET BAYAT 
* on 1.02.2024 at 5:20 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Database(entities = [Player::class], version = 1) // , exportSchema = false
abstract class PlayerDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao
}