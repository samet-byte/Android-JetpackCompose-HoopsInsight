package com.sametb.hoopsinsight.presentation.screens.search

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.search
* Created by SAMET BAYAT 
* on 4.02.2024 at 3:35 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun SearchScreen(
    navController: NavHostController,
) {
    SearchScreenContent()
}

@Composable
fun SearchScreenContent() {

    Scaffold(
        topBar = {
            SearchTopAppBar(
                text = "",
                onTextChange = {},
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }
    ) {

    }
}
