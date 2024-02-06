package com.sametb.hoopsinsight.presentation.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sametb.hoopsinsight.presentation.common.ListContent
import com.sametb.hoopsinsight.ui.theme.statusBarColor


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.search
* Created by SAMET BAYAT 
* on 4.02.2024 at 3:35 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    // pop back from player status bar color issue fix
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = statusBarColor(darkTheme = isSystemInDarkTheme())
    )


    SearchScreenContent(
        searchViewModel = searchViewModel,
        navController = navController
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreenContent(searchViewModel: SearchViewModel, navController: NavHostController) {

    val searchQuery by searchViewModel.searchQuery
    val searchResults = searchViewModel.searchResults.collectAsLazyPagingItems()



    Scaffold(
        topBar = {
            SearchTopAppBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(it)
                },
                onSearchClicked = {
                    searchViewModel.searchPlayers(it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        Box(
            Modifier
                .padding(it)
            ,
            contentAlignment = androidx.compose.ui.Alignment.Center,
        ) {
            ListContent(players = searchResults, navController = navController)
        }

    }
}
