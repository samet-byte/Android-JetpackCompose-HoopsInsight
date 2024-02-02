package com.sametb.hoopsinsight.domain.model.player

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sametb.hoopsinsight.domain.model.player.sub.Award
import com.sametb.hoopsinsight.domain.model.player.sub.Info
import com.sametb.hoopsinsight.domain.model.player.sub.Stats
import com.sametb.hoopsinsight.util.constants.RoomConstants


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.model
* Created by SAMET BAYAT 
* on 1.02.2024 at 4:49 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/


@Entity(tableName = RoomConstants.ROOM_DB_PLAYER_TABLE)
data class Player(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val awards: List<Award>? = emptyList(),
    val cmsBio: String? = "",
    val info: Info,
    val rotowireBio: String? = "",
    val stats: Stats
)
