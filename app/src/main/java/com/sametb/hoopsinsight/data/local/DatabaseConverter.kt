package com.sametb.hoopsinsight.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sametb.hoopsinsight.domain.model.player.Player


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local
* Created by SAMET BAYAT 
* on 1.02.2024 at 5:41 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class DatabaseConverter {
    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        list.forEach {
            stringBuilder.append(it)
            stringBuilder.append(separator)
        }
//        stringBuilder.deleteCharAt(stringBuilder.length - separator.length) // remove last separator Approach #1
        stringBuilder.setLength(stringBuilder.length - separator.length) // remove last separator Approach #2
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }


    @TypeConverter
    fun playerToString(player: Player?): String? {
        return player?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun stringToPlayer(data: String?): Player? {
        return data?.let { Gson().fromJson(it, Player::class.java) }
    }

}