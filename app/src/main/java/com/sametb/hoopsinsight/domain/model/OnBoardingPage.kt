package com.sametb.hoopsinsight.domain.model

import androidx.annotation.DrawableRes
import com.sametb.hoopsinsight.R


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.model
* Created by SAMET BAYAT 
* on 1.02.2024 at 10:54 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

sealed class OnBoardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
){
    object FirstPage: OnBoardingPage(
        image = R.drawable.hoop,
        title = "Welcome to Hoops Insight",
        description = "Hoops Insight is a basketball app that provides you with the latest news, stats, and highlights."
    )
    object SecondPage: OnBoardingPage(
        image = R.drawable.sengun,
        title = "Get the latest news",
        description = "Get the latest news from the NBA."
    )
    object ThirdPage: OnBoardingPage(
        image = R.drawable.shaq,
        title = "Get the latest stats",
        description = "Get the latest stats from the NBA."
    )
}
