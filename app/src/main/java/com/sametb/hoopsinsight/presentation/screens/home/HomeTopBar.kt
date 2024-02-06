package com.sametb.hoopsinsight.presentation.screens.home

import android.content.res.Configuration
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.ui.theme.appBarBgAndContentColor
import com.sametb.hoopsinsight.util.constants.AppConstants
import com.sametb.hoopsinsight.util.constants.ViewConstants


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.home
* Created by SAMET BAYAT 
* on 2.02.2024 at 7:22 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeTopAppBar(
    onSearchClicked: () -> Unit = {}
) {

    TopAppBar(
        title = {
            Text(
                text = "${AppConstants.APP_NAME}",
                color = appBarBgAndContentColor(ViewConstants.CONTENT),
                fontFamily = basketballFontFamily
            )
        },
        backgroundColor = appBarBgAndContentColor(ViewConstants.BACKGROUND),
        contentColor = appBarBgAndContentColor(ViewConstants.CONTENT),
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        },
        modifier = Modifier
            .shadow(ambientColor = Color.LightGray, elevation = 10.dp),

        )
}



// preview for dark theme