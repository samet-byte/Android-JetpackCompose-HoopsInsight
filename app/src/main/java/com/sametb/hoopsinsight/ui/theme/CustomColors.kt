package com.sametb.hoopsinsight.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


/*
* Hoops Insight.com.sametb.hoopsinsight.ui.theme
* Created by SAMET BAYAT 
* on 1.02.2024 at 11:35 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/


val STATUS_BAR_COLOR_LIGHT = Color.Blue
val MIDDLE_BG_COLOR_LIGHT = Color.White
val BOTTOM_BG_COLOR_LIGHT = Color.Red

val STATUS_BAR_COLOR_DARK = Color.Black
val BOTTOM_BG_COLOR_DARK = Color.DarkGray

fun statusBarColor(darkTheme: Boolean = false) =
    when {
        darkTheme -> STATUS_BAR_COLOR_DARK
        else -> STATUS_BAR_COLOR_LIGHT
    }

@Composable
fun welcomeScreenBackgroundColor(darkTheme: Boolean = false) =
    when {
        darkTheme -> STATUS_BAR_COLOR_DARK
        else -> Color.White
    }

@Composable
fun textColor(
    darkTheme: Boolean = false,
    alpha: Float = 1f
) = when {
    darkTheme -> Color.
                    LightGray
                    .copy(alpha = alpha)
    else -> Color.
                    DarkGray
                    .copy(alpha = alpha)
}

@Composable
fun activeIndicatorAndButtonColor(darkTheme: Boolean = false) =
    when {
        darkTheme -> Color.
                        White
        else -> STATUS_BAR_COLOR_LIGHT
    }
