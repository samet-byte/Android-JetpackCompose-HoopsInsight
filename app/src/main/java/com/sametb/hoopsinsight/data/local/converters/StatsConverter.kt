package com.sametb.hoopsinsight.data.local.converters

import androidx.room.TypeConverter
import com.sametb.hoopsinsight.domain.model.player_paging.sub.Stats
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.converters
* Created by SAMET BAYAT 
* on 1.02.2024 at 8:05 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@OptIn(ExperimentalSerializationApi::class)
class StatsConverter {

    @TypeConverter
    fun convertToJsonString(stats: Stats?): String {
        return Json.encodeToString(stats)
    }

    @TypeConverter
    fun convertToStats(jsonString: String): Stats {
        return Json.decodeFromString(jsonString)
    }
}