package com.sametb.hoopsinsight.domain.model

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
@Entity(tableName = RoomConstants.PLAYER_REMOTE_KEY_DB_TABLE)
data class PlayerRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val prevPage: Int?,
    val nextPage: Int?


)
