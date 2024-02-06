package com.sametb.hoopsinsight.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.components
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:09 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, backgroundColor = 0xFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InfoBoxStat(
    title: String = "PTS",
    value: Double? = 0.0,
    textColor: Int = com.sametb.hoopsinsight.ui.theme.textColor().toArgb(),
    fontFamily: androidx.compose.ui.text.font.FontFamily = basketballFontFamily,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = androidx.compose.ui.graphics.Color(textColor),
            fontFamily = fontFamily,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = fontWeight
        )
//        Spacer(modifier = androidx.compose.ui.Modifier.weight(1f))
        Text(
            text = value.toString(),
            color = androidx.compose.ui.graphics.Color(textColor),
            fontFamily = fontFamily,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            fontWeight = fontWeight
        )
    }
}