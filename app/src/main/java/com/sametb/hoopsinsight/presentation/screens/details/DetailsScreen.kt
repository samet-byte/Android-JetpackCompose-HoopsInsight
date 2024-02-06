package com.sametb.hoopsinsight.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sametb.hoopsinsight.util.functions.PaletteGenerator
import kotlinx.coroutines.flow.collectLatest


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
    val player by detailsScreenViewModel.player.collectAsState()

    val colorPalette by detailsScreenViewModel.colorPalette

    if (colorPalette.isEmpty()) {
        detailsScreenViewModel.generateColorPalette()
    } else {
        DetailsContent(
            navController = navController,
            player = player,
            colors = colorPalette
        )
    }

    val context = LocalContext.current

    LaunchedEffect(
        key1 = true,
    ) {
        detailsScreenViewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.GenerateColorPalette -> {
                    val bitmap = player?.info?.IMAGE?.let {
                        PaletteGenerator.convertImageUrlToBitmap(
                            imageUrl = it,
                            context = context
                        )
                    }
                    if (bitmap != null) {
                        detailsScreenViewModel.setColorPalette(
                            colors = PaletteGenerator.extractColorsFromBitmap(bitmap = bitmap)
                        )
                    }
                }
            }
        }
    }

}