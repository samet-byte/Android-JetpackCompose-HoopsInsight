package com.sametb.hoopsinsight.data.local.converters

import androidx.room.TypeConverter
import com.sametb.hoopsinsight.domain.model.player.sub.Info
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.converters
* Created by SAMET BAYAT 
* on 1.02.2024 at 8:03 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@OptIn(ExperimentalSerializationApi::class)
class InfoConverter {

    @TypeConverter
    fun convertToJsonString(info: Info?): String {
        return Json.encodeToString(info)
    }

    @TypeConverter
    fun convertToInfo(jsonString: String): Info {
        return Json.decodeFromString(jsonString)
    }





}