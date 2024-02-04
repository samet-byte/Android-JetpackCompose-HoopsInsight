package com.sametb.hoopsinsight.domain.model.player_paging.sub

import kotlinx.serialization.Serializable

@Serializable
data class Award(
    val count: Int? = null,
    val name: String? = null,
)