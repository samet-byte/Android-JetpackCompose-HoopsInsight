package com.sametb.hoopsinsight.presentation.screens.search

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.sametb.hoopsinsight.presentation.common.ListContent


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
        ListContent(players = searchResults, navController = navController)
    }
}
