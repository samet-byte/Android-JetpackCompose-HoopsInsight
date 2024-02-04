package com.sametb.hoopsinsight.presentation.common

import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.ui.theme.emptyScreenContentColor
import kotlinx.coroutines.delay
import java.net.ConnectException
import java.net.SocketTimeoutException


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.common
* Created by SAMET BAYAT 
* on 4.02.2024 at 2:17 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

val DEFAULT_ERROR = LoadState.Error(
//        ConnectException()
        SocketTimeoutException()
//        Exception()
)

//@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF,)
//@Preview(
//    showBackground = true,
//    backgroundColor = 0xFF000000,
//    uiMode = Configuration.UI_MODE_NIGHT_YES
//)
@Composable
fun EmptyScreen(
    error: LoadState.Error = DEFAULT_ERROR
) {
    val message by remember { mutableStateOf(parseErrorMessage(error)) }
    val icon by remember { mutableIntStateOf(R.drawable.ic_network_error) }


    // __ Animation Just Fade In __
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation by animateFloatAsState(
        targetValue = if (startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000,
        ),
        label = "EmptyScreenAlphaAnimation"
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
    }


    // __ Animation Fade In and Out __
    val fadeInOutState = rememberInfiniteTransition(label = "fadeInOutState")
    val alphaValueFadeInOut by fadeInOutState.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )



    EmptyScreenContent(
        icon,
        message,
//        alphaAnimation
        alphaValueFadeInOut
    )
}

@Composable
private fun EmptyScreenContent(
    icon: Int,
    message: String,
    alphaAnimation: Float,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .alpha(alpha = alphaAnimation)
                ,
                colorFilter = ColorFilter.tint(emptyScreenContentColor())
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                modifier = Modifier
                    .alpha(alpha = alphaAnimation)
                ,
                color = emptyScreenContentColor(),
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = basketballFontFamily,
                textAlign = TextAlign.Center,
                minLines = 2
            )
        }
    }
}

fun parseErrorMessage(error: LoadState.Error): String {
    Log.d("EmptyScreen", "parseErrorMessage: $error")
    return when (error.error) {
        is SocketTimeoutException -> "Server Unavailable"
        is ConnectException -> "No Internet Connection, c'mon!"
        else -> "We have no idea what's going on.\nTry again later."
    }
}
