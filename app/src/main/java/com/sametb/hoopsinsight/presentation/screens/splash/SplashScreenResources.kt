package com.sametb.hoopsinsight.presentation.screens.splash

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.ui.theme.BOTTOM_BG_COLOR_DARK
import com.sametb.hoopsinsight.ui.theme.BOTTOM_BG_COLOR_LIGHT
import com.sametb.hoopsinsight.ui.theme.MIDDLE_BG_COLOR_LIGHT
import com.sametb.hoopsinsight.ui.theme.STATUS_BAR_COLOR_DARK
import com.sametb.hoopsinsight.ui.theme.STATUS_BAR_COLOR_LIGHT


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.splash
* Created by SAMET BAYAT 
* on 1.02.2024 at 10:22 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

val iconLight = R.drawable.nba_logo_light
val iconDark = R.drawable.nba_logo_dark


val lightThemeBackgroundBrush
        = Brush
    .verticalGradient(
        listOf(
            STATUS_BAR_COLOR_LIGHT,
            MIDDLE_BG_COLOR_LIGHT,
            BOTTOM_BG_COLOR_LIGHT,
        ))

val darkThemeBackgroundBrush
        = Brush
    .verticalGradient(
        listOf(
            STATUS_BAR_COLOR_DARK,
            BOTTOM_BG_COLOR_DARK,
        ))
