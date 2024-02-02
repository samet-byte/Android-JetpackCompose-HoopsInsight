package com.sametb.hoopsinsight.presentation.screens.home

import android.content.res.Configuration
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.sametb.hoopsinsight.ui.theme.customBackgroundColor
import com.sametb.hoopsinsight.util.functions.isProbablyRunningOnEmulator


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.home
* Created by SAMET BAYAT
* on 2.02.2024 at 6:30 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun HomeScreen(
//    navController: NavHostController,
) {
    HomeScreenContent()
}


//@Preview
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenContent(
) {
    Scaffold(
        topBar = {HomeTopAppBar()},
        backgroundColor = customBackgroundColor(darkThemeBgColorAlpha = .97f)

    ){
        Text(text = "$isProbablyRunningOnEmulator")
    }
}
