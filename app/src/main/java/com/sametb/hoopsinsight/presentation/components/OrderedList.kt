package com.sametb.hoopsinsight.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.sametb.hoopsinsight.domain.model.player_paging.Luka_Dončić
import com.sametb.hoopsinsight.domain.model.player_paging.sub.Award
import com.sametb.hoopsinsight.ui.theme.SMALL_PADDING
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.ui.theme.textColor


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.components
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:26 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun OrderedList(
    title: String,
    items: List<Award>?,
    textColor: Color,
) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = SMALL_PADDING)
            ,
            text = title,
            color = textColor,
            fontFamily = basketballFontFamily,
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
        )
        items?.forEach {award ->
            Text(
//                modifier = Modifier
//                    .padding(SMALL_PADDING),
                text = "${award.count}x ${award.name}",
                color = textColor,
                fontFamily = basketballFontFamily,
//                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, )
@Preview(showBackground = true, backgroundColor = 0x000000, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OrderedListPreview() {
    OrderedList(
        title = "Awards",
        items = Luka_Dončić.awards,
        textColor = textColor()
    )
}
