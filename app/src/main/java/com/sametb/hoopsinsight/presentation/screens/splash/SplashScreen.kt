package com.sametb.hoopsinsight.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.nav.Screen


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.splash
* Created by SAMET BAYAT 
* on 1.02.2024 at 7:01 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun SplashScreen(
    navController: NavHostController
) {

    val rotateAnimation = remember { Animatable(0f) }

    LaunchedEffect(
        key1 = true
    ) {
        rotateAnimation.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1500,
                delayMillis = 20
            )
        )
        navController.navigate(Screen.Welcome.route)

    }
    Splash(rotateAnimation.value)

}


//@Preview
@Composable
fun  Splash(rotateDegrees: Float = 0f) {
    if (!isSystemInDarkTheme()) SplashScreenContent(rotateDegrees = rotateDegrees)
    else SplashScreenContent(
        icon = iconDark,
        brush = darkThemeBackgroundBrush,
        rotateDegrees = rotateDegrees
    )
}

@Composable
fun SplashScreenContent(
    icon: Int = iconLight,
    brush: Brush = lightThemeBackgroundBrush,
    rotateDegrees: Float = 0f
) {
    Box(
        modifier = Modifier
            .background(brush = brush)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.app_logo),
            modifier = Modifier
                .height(1.5*100.dp)
                .rotate(degrees = rotateDegrees)
            ,
        )
    }
}


