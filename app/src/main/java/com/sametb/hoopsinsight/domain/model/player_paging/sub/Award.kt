package com.sametb.hoopsinsight.domain.model.player_paging.sub

import kotlinx.serialization.Serializable

@Serializable
data class Award(
    val count: String? = null,
    val name: String? = null,
)