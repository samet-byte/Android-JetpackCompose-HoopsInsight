package com.sametb.hoopsinsight.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sametb.hoopsinsight.domain.model.player_paging.sub.Award


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.converters
* Created by SAMET BAYAT 
* on 1.02.2024 at 7:11 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/


class AwardConverter {
    @TypeConverter
    fun fromAwardList(awards: List<Award>?): String {
        return Gson().toJson(awards)
    }

    @TypeConverter
    fun toAwardList(awardsJson: String): List<Award>? {
        return Gson().fromJson(awardsJson, object : TypeToken<List<Award>>() {}.type)
    }
}