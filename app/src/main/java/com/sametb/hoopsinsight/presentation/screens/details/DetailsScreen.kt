package com.sametb.hoopsinsight.presentation.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.details
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:08 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsScreenViewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val player = detailsScreenViewModel.player
player.value?.let {
        Text(
            text = it.info.DISPLAY_FIRST_LAST,
        )
    }
}