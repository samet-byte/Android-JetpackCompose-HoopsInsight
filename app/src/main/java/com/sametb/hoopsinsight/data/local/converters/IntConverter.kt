package com.sametb.hoopsinsight.data.local.converters


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.converters
* Created by SAMET BAYAT 
* on 1.02.2024 at 8:30 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IntConverter {
    private val gson = Gson()

    @TypeConverter
    fun convertToJsonString(count: Int?): String? {
        return gson.toJson(count)
    }

    @TypeConverter
    fun convertToInt(jsonString: String?): Int? {
        return gson.fromJson(jsonString, object : TypeToken<Int?>() {}.type)
    }
}