package com.sametb.hoopsinsight.util.constants

import android.util.Log
import com.sametb.hoopsinsight.util.functions.isProbablyRunningOnEmulator


/*
* Hoops Insight.com.sametb.hoopsinsight.util.constants
* Created by SAMET BAYAT 
* on 2.02.2024 at 10:11 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

object ApiConstants {
    const val EMULATOR_LOCAL_BASE_URL = "http://10.0.2.2:8080"
    const val LOCAL_BASE_URL = "http://192.168.1.28:8080"
    const val BASE_URL = "https://hoops-insight.herokuapp.com"
    const val API_BASE = "/nba/players"
    const val GET_PLAYER_BY_ID = "$API_BASE/search"

    const val PAGE = "page"
    const val NAME = "name"

    const val CONTENT_TYPE = "application/json"

    const val IMAGE_PLACEHOLDER_URL = "https://sdk.bitmoji.com/render/panel/10213250-100025018093_12-s5-v1.png?transparent=1&palette=1&scale=2"

    object NBAOfficialImage {
        fun playerImageUrl(playerId: Int): String =
            "https://cdn.nba.com/headshots/nba/latest/1040x760/$playerId.png"

        fun teamLogoUrl(teamId: Int): String {
//            val teamLogoUrl = "https://cdn.nba.com/logos/nba/$teamId/primary/L/logo.png"
            val teamLogoUrl = "${decideLocalBaseUrl()}/logo/$teamId.png"
            Log.d("ApiConstants", "teamLogoUrl: $teamLogoUrl")
            return teamLogoUrl
        }
    }
}

fun decideLocalBaseUrl(isEmulator: Boolean = isProbablyRunningOnEmulator): String {
    return if (isEmulator) ApiConstants.EMULATOR_LOCAL_BASE_URL
    else ApiConstants.LOCAL_BASE_URL
}
