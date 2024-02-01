package com.sametb.hoopsinsight.nav

import com.sametb.hoopsinsight.util.constants.NavConstants


/*
* Hoops Insight.com.sametb.hoopsinsight.nav
* Created by SAMET BAYAT 
* on 1.02.2024 at 3:18 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

sealed class Screen(
    val route: String
){
    object Splash: Screen(NavConstants.SPLASH_SCREEN)
    object Welcome: Screen(NavConstants.WELCOME_SCREEN)
    object Home: Screen(NavConstants.HOME_SCREEN)
    object Details: Screen("${NavConstants.DETAILS_SCREEN}/{${NavConstants.DETAILS_ARGUMENT_ID_KEY}}") {
        fun passId(id: Int) = "${NavConstants.DETAILS_SCREEN}/$id"
    }
    object Search: Screen(NavConstants.SEARCH_SCREEN)
}
