package com.sametb.hoopsinsight.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.nav.Screen
import com.sametb.hoopsinsight.presentation.common.ListContent
import com.sametb.hoopsinsight.ui.theme.customBackgroundColor


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.home
* Created by SAMET BAYAT
* on 2.02.2024 at 6:30 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val allPlayers = homeViewModel.getAllPlayers.collectAsLazyPagingItems()


    HomeScreenContent(
        players = allPlayers,
        navController = navController
    )
}


//@Preview
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenContent(
    players: LazyPagingItems<Player>,
    navController: NavHostController,
) {
    Scaffold(
        topBar = {HomeTopAppBar(
            onSearchClicked = {navController.navigate(Screen.Search.route)}
        )},
        backgroundColor = customBackgroundColor(darkThemeBgColorAlpha = .97f),
        content = { paddingValues -> Box(modifier = Modifier.padding(paddingValues)){
            ListContent(players = players, navController = navController)
        } }
    )
}

private operator fun PaddingValues.plus(padding: Dp): Dp = this + padding
