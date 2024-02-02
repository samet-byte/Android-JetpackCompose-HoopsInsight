package com.sametb.hoopsinsight.domain.model

import com.sametb.hoopsinsight.domain.model.player_paging.Player
import kotlinx.serialization.Serializable


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.model
* Created by SAMET BAYAT 
* on 2.02.2024 at 9:43 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val players: List<Player> = emptyList()
)
