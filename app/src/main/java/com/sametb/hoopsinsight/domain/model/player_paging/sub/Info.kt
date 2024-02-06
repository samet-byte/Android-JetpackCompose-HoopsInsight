package com.sametb.hoopsinsight.domain.model.player_paging.sub

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val BIRTHDATE: String? = null,
    val COUNTRY: String? = null,
    val DISPLAY_FIRST_LAST: String,
    val DISPLAY_FI_LAST: String? = null,
    val DISPLAY_LAST_COMMA_FIRST: String? = null,
    val DLEAGUE_FLAG: String? = null,
    val DRAFT_NUMBER: String? = null,
    val DRAFT_ROUND: String? = null,
    val DRAFT_YEAR: String? = null,
    val FIRST_NAME: String? = null,
    val FROM_YEAR: Int? = null,
    val GAMES_PLAYED_CURRENT_SEASON_FLAG: String? = null,
    val GAMES_PLAYED_FLAG: String? = null,
    val GREATEST_75_FLAG: String? = null,
    val HEIGHT: String? = null,
    val IMAGE: String? = null,
    val JERSEY: String? = null,
    val LAST_AFFILIATION: String? = null,
    val LAST_NAME: String? = null,
    val NBA_FLAG: String? = null,
    val PERSON_ID: Int? = null,
    val PLAYERCODE: String? = null,
    val PLAYER_SLUG: String? = null,
    val POSITION: String? = null,
    val ROSTERSTATUS: String? = null,
    val SCHOOL: String? = null,
    val SEASONS: List<String>? = null,
    val SEASON_EXP: Int? = null,
    val TEAM_ABBREVIATION: String? = null,
    val TEAM_CITY: String? = null,
    val TEAM_CODE: String? = null,
    val TEAM_ID: Int? = null,
    val TEAM_NAME: String? = null,
    val TO_YEAR: Int? = null,
    val WEIGHT: String? = null,
)