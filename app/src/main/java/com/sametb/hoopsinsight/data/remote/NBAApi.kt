package com.sametb.hoopsinsight.data.remote

import com.sametb.hoopsinsight.domain.model.ApiResponse
import com.sametb.hoopsinsight.util.constants.ApiConstants.API_BASE
import com.sametb.hoopsinsight.util.constants.ApiConstants.GET_PLAYER_BY_ID
import com.sametb.hoopsinsight.util.constants.ApiConstants.NAME
import com.sametb.hoopsinsight.util.constants.ApiConstants.PAGE
import retrofit2.http.GET
import retrofit2.http.Query


/*
* Hoops Insight.com.sametb.hoopsinsight.data.local.remote
* Created by SAMET BAYAT 
* on 2.02.2024 at 9:54 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

interface NBAApi {

    @GET(API_BASE)
    suspend fun getAllPlayers(
        @Query(PAGE) page: Int = 1,
    ): ApiResponse

    @GET(GET_PLAYER_BY_ID)
    suspend fun searchPlayers(
        @Query(NAME) name: String
    ): ApiResponse

}