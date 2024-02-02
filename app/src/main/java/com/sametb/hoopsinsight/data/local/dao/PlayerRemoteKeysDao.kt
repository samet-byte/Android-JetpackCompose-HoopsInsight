package com.sametb.hoopsinsight.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sametb.hoopsinsight.domain.model.player_paging.PlayerRemoteKeys


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.dao
* Created by SAMET BAYAT 
* on 1.02.2024 at 5:33 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Dao
interface  PlayerRemoteKeysDao {

    @Query("SELECT * FROM player_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKey(id: Int): PlayerRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<PlayerRemoteKeys>)

    @Query("DELETE FROM player_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}