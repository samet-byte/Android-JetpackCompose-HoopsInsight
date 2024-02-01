package com.sametb.hoopsinsight.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sametb.hoopsinsight.util.constants.NavConstants


/*
* Hoops Insight.com.sametb.hoopsinsight.nav
* Created by SAMET BAYAT 
* on 1.02.2024 at 3:38 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {

        }
        composable(route = Screen.Welcome.route) {

        }
        composable(route = Screen.Home.route) {

        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(NavConstants.DETAILS_ARGUMENT_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) {

        }
        composable(route = Screen.Search.route) {

        }
    }
}