package com.sametb.hoopsinsight.util.constants

import com.sametb.hoopsinsight.util.functions.isProbablyRunningOnEmulator


/*
* Hoops Insight.com.sametb.hoopsinsight.util.constants
* Created by SAMET BAYAT 
* on 2.02.2024 at 10:11 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

object ApiConstants {
    const val EMULATOR_LOCAL_BASE_URL = "http://10.0.2.2:8080"
    const val LOCAL_BASE_URL = "http://localhost:8080"
    const val BASE_URL = "https://hoops-insight.herokuapp.com"
    const val API_BASE = "/nba/players"
    const val GET_PLAYER_BY_ID = "$API_BASE/search"

    const val PAGE = "page"
    const val NAME = "name"

    const val CONTENT_TYPE = "application/json"
}

fun decideLocalBaseUrl(isEmulator: Boolean = isProbablyRunningOnEmulator): String {
    return if (isEmulator) ApiConstants.EMULATOR_LOCAL_BASE_URL
    else ApiConstants.LOCAL_BASE_URL
}