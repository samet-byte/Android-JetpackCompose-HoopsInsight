package com.sametb.hoopsinsight.domain.model.player_paging.sub

import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val AST: Double? = null,
    val PIE: Double? = null,
    val PLAYER_ID: Int,
    val PLAYER_NAME: String,
    val PTS: Double? = null,
    val REB: Double? = null,
    val TimeFrame: String? = null,
    val ALL_STAR_APPEARANCES: Int? = null,
)