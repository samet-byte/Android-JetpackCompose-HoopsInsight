package com.sametb.hoopsinsight.util.constants


/*
* Hoops Insight.com.sametb.hoopsinsight.util.constants
* Created by SAMET BAYAT 
* on 4.02.2024 at 1:24 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

object CacheConstants {
    // in minutes
    const val CACHE_TIMEOUT = 1

    fun differenceInMinutes(
        currentTimestamp: Long,
        lastUpdated: Long
    ): Int {
        return(
                (currentTimestamp - lastUpdated) / 1000 / 60
                ).toInt()
    }

    object LogTags {
        const val PLAYER_REMOTE_MEDIATOR = "PlayerRemoteMediator"
    }
}