package com.sametb.hoopsinsight.util.constants


/*
* Hoops Insight.com.sametb.hoopsinsight.util.constants
* Created by SAMET BAYAT 
* on 2.02.2024 at 7:28 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

object ViewConstants {
    const val BACKGROUND = "background"
    const val CONTENT = "content"


    const val DEFAULT_RATING = 3.5
}


fun randomRatingWithPoint5 (): Double {
    val ratingArray = arrayOf(0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0)
    return ratingArray.random()
}