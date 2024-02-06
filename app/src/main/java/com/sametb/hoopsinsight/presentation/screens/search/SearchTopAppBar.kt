package com.sametb.hoopsinsight.presentation.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sametb.hoopsinsight.ui.theme.TOP_APP_BAR_HEIGHT
import com.sametb.hoopsinsight.ui.theme.appBarBgAndContentColor
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.util.constants.ViewConstants

/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.search
* Created by SAMET BAYAT 
* on 4.02.2024 at 3:38 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun SearchTopAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    SearchWidget(
        text = text,
        onTextChange = onTextChange,
        onSearchClicked = onSearchClicked,
        onCloseClicked = onCloseClicked
    )
}

@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = appBarBgAndContentColor()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.White,
                    fontFamily = basketballFontFamily
                )
            },
            textStyle = TextStyle(
                color = appBarBgAndContentColor(where = ViewConstants.CONTENT)
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(alpha = ContentAlpha.medium),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_icon),
                        tint = appBarBgAndContentColor(where = ViewConstants.CONTENT)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = appBarBgAndContentColor(where = ViewConstants.CONTENT),
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = appBarBgAndContentColor(where = ViewConstants.CONTENT),
            )
        )
    }
}

@Composable
@Preview
fun SearchWidgetPreview() {
    SearchWidget(
        text = "",
        onTextChange = {},
        onSearchClicked = {},
        onCloseClicked = {}
    )
}