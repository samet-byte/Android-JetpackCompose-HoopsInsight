package com.sametb.hoopsinsight.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

@Deprecated(message = "MaterialTheme3 not allows to access colors directly", level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith(
        "if (isLight) Color.Blue.toArgb() else Color.Black.toArgb()",
        "androidx.compose.ui.graphics.Color",
        "androidx.compose.ui.graphics.toArgb",
        "androidx.compose.ui.graphics.Color",
        "androidx.compose.ui.graphics.toArgb"
    )
)
val Colors.statusBarColor
    @Composable
    get() = if (isLight) Color.Blue.toArgb() else Color.Black.toArgb()

//@Deprecated(message = "MaterialTheme3 not allows to access colors directly", level = DeprecationLevel.WARNING,
//    replaceWith = ReplaceWith(
//        "if (isLight) Color.White else Color.Black",
//        "androidx.compose.ui.graphics.Color",
//        "androidx.compose.ui.graphics.Color"
//    )
//)
val Colors.welcomeScreenBackgroundColor
    @Composable
    get() = if (isLight) Color.White else Color.Black


val StarColor = Color ( 0xFFFFC94D)