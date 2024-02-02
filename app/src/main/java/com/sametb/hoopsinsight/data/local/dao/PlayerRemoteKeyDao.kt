package com.sametb.hoopsinsight.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sametb.hoopsinsight.domain.model.player_paging.PlayerRemoteKey


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.dao
* Created by SAMET BAYAT 
* on 1.02.2024 at 5:33 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Dao
interface PlayerRemoteKeyDao {

    @Query("SELECT * FROM player_remote_key_table WHERE id = :id")
    suspend fun getRemoteKey(id: Int): PlayerRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<PlayerRemoteKey>)

    @Query("DELETE FROM player_remote_key_table")
    suspend fun deleteAllRemoteKeys()
}