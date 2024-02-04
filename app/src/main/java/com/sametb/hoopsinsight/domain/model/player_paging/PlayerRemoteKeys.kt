package com.sametb.hoopsinsight.domain.model.player_paging

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sametb.hoopsinsight.util.constants.RoomConstants


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.model
* Created by SAMET BAYAT 
* on 1.02.2024 at 5:30 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

// Remote keys table for pagination
@Entity(tableName = RoomConstants.PLAYER_REMOTE_KEYS_DB_TABLE)
data class PlayerRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val prevPage: Int?,
    val nextPage: Int?,

    // Last updated time in milliseconds, used to check if remote keys are expired
    // or exceeds the validity period
    val lastUpdated: Long?,
)
