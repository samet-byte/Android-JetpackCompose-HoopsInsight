package com.sametb.hoopsinsight.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sametb.hoopsinsight.util.constants.ContentConstants


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

val BEIGE = Color(0xFFFFECD6)

fun statusBarColor(darkTheme: Boolean = false) =
    when {
        darkTheme -> STATUS_BAR_COLOR_DARK
        else -> STATUS_BAR_COLOR_LIGHT
    }

@Composable
fun customBackgroundColor(
    darkTheme: Boolean = isSystemInDarkTheme(),
    darkThemeBgColor: Color = STATUS_BAR_COLOR_DARK,
    darkThemeBgColorAlpha: Float = 1f,
    lightThemeBgColor: Color = Color.White,
    lightThemeBgColorAlpha: Float = 1f,
) =
    when {
        darkTheme -> darkThemeBgColor.copy(alpha = darkThemeBgColorAlpha)
        else -> lightThemeBgColor.copy(alpha = lightThemeBgColorAlpha)
    }

@Composable
fun textColor(
    darkTheme: Boolean = false,
    alpha: Float = 1f,
    darkThemeColor: Color = Color.LightGray,
    lightThemeColor: Color = Color.DarkGray
) = when {
    darkTheme -> darkThemeColor.copy(alpha = alpha)
    else -> lightThemeColor.copy(alpha = alpha)
}

@Composable
fun activeIndicatorAndButtonColor(darkTheme: Boolean = false) =
    when {
        darkTheme -> Color.
                        White
        else -> STATUS_BAR_COLOR_LIGHT
    }



@Composable
fun appBarBgContentColor(
    where: String = ContentConstants.BACKGROUND,
    darkTheme: Boolean = isSystemInDarkTheme(),
) =
    when(where) {
        ContentConstants.BACKGROUND -> if (darkTheme) Color.Black else Color.Blue
        else -> if (darkTheme) Color.LightGray else Color.White
}