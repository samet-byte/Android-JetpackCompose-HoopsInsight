package com.sametb.hoopsinsight.presentation.screens.details

import android.graphics.Color.parseColor
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.BottomSheetValue.Collapsed
import androidx.compose.material.BottomSheetValue.Expanded
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.domain.model.player_paging.Luka_Dončić
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.presentation.components.InfoBoxStat
import com.sametb.hoopsinsight.presentation.components.OrderedList
import com.sametb.hoopsinsight.ui.theme.EXPANDED_RADIUS_LEVEL
import com.sametb.hoopsinsight.ui.theme.EXTRA_LARGE_PADDING
import com.sametb.hoopsinsight.ui.theme.INFO_ICON_SIZE
import com.sametb.hoopsinsight.ui.theme.LARGE_PADDING
import com.sametb.hoopsinsight.ui.theme.MEDIUM_PADDING
import com.sametb.hoopsinsight.ui.theme.MIN_BACKGROUND_IMAGE_HEIGHT
import com.sametb.hoopsinsight.ui.theme.MIN_SHEET_HEIGHT
import com.sametb.hoopsinsight.ui.theme.SMALL_PADDING
import com.sametb.hoopsinsight.ui.theme.appBarBgAndContentColor
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.util.constants.ApiConstants


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.details
* Created by SAMET BAYAT
* on 4.02.2024 at 7:16 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun DetailsContent(
    navController: NavHostController,
    detailsScreenViewModel: DetailsScreenViewModel = hiltViewModel(),
    player: Player?,
    colors: Map<String, String>
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = Color(parseColor(colors["darkVibrant"]!!)),
//        darkIcons = true
    )


    // Palette
    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#FFFFFF") }

    LaunchedEffect(key1 = player){
        vibrant = colors["vibrant"]!!
        darkVibrant = colors["darkVibrant"]!!
        onDarkVibrant = colors["onDarkVibrant"]!!
    }


    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )


    val radiusAnim by animateDpAsState(
        targetValue =
        if (scaffoldState.currentSheetFraction == 1f)
            EXTRA_LARGE_PADDING
        else
            EXPANDED_RADIUS_LEVEL,
        label = "radiusAnim"
    )

    val playerImageUrl = ApiConstants.NBAOfficialImage.playerImageUrl(player?.info?.PERSON_ID ?:  2246)
    val teamLogoUrl = ApiConstants.NBAOfficialImage.teamLogoUrl(player?.info?.TEAM_ID ?: 1610612742)


    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim,
        ),
        scaffoldState = scaffoldState,
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContent = {
            player?.let {
                BottomSheetContent(
                    player = it,
                    infoBoxContentColor = Color(parseColor(vibrant)),
                    sheetBgColor = Color(parseColor(darkVibrant)),
                    contentColor = Color(parseColor(vibrant)),
                    teamLogoUrl = teamLogoUrl
                )
            }
        }
    ) {

        BackgroundContent(
            playerImageUrl = playerImageUrl,
            teamLogoUrl = teamLogoUrl,
            imageFraction = scaffoldState.currentSheetFraction,
            onCloseClicked = {
                navController.popBackStack()
            },
            backgroundColor = Color(parseColor(darkVibrant)),
            tintColor = Color(parseColor(onDarkVibrant)),
            )

    }
}


@OptIn(ExperimentalCoilApi::class)
//@Preview(
////    showBackground = true,
////    backgroundColor = 0xFFFFFFFF
//)
@Composable
fun BottomSheetContent(
    player: Player = Luka_Dončić,
    infoBoxContentColor: Color = appBarBgAndContentColor(),
    sheetBgColor: Color,// = customBackgroundColor(),
    contentColor: Color, // = textColor(
    teamLogoUrl: String,
//        darkThemeColor = Color.White,
//        lightThemeColor = Color.White
//        ),
    ) {


    val teamLogoPainter = rememberImagePainter(
        data = teamLogoUrl,
    ){
        error(R.drawable.nba_icon_no_title)
    }

    Column(
        modifier = Modifier
            .background(color = sheetBgColor)
            .padding(LARGE_PADDING)
        ,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LARGE_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .weight(8f)
                ,

                contentAlignment = Alignment.CenterStart
            ){
                Text(
                    text = "#${player.info.JERSEY}  ${player.info.DISPLAY_LAST_COMMA_FIRST}",
                    color = contentColor,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    fontFamily = basketballFontFamily,

                )
            }
            Image(
//                painter = logoPainter,
                painter = teamLogoPainter,
                contentDescription = "NBA Logo",
                modifier = Modifier
                    .size(INFO_ICON_SIZE)
                    .weight(2f)
                ,
                alignment = Alignment.CenterEnd
//                tint = contentColor
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MEDIUM_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoBoxStat(
                title = "PTS",
                value = player.stats.PTS,
                textColor = contentColor.toArgb(),
                fontFamily = basketballFontFamily
            )
            InfoBoxStat(
                title = "AST",
                value = player.stats.AST,
                textColor = contentColor.toArgb(),
                fontFamily = basketballFontFamily
            )
            InfoBoxStat(
                title = "REB",
                value = player.stats.REB,
                textColor = contentColor.toArgb(),
                fontFamily = basketballFontFamily
            )
        }
/*

        Text(
//            modifier = Modifier.fillMaxWidth(),
            text = player.rotowireBio.toString(),
            color = contentColor,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
//            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            fontFamily = basketballFontFamily,
            maxLines = 10,
            overflow = TextOverflow.Ellipsis
        )
*/

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (player.awards?.isNotEmpty() == true) {
                OrderedList(
                    title = "Awards",
                    items = player.awards,
                    textColor = contentColor
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun BackgroundContent(
    playerImageUrl: String,
    teamLogoUrl: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    onCloseClicked: () -> Unit,
    tintColor: Color
) {
    val playerPainter = rememberImagePainter(playerImageUrl) {
        error(R.drawable.sam_basketball_placeholder)
    }


    val teamLogoPainter = rememberImagePainter(
        data = teamLogoUrl,
//        builder = {
//            crossfade(true)
//        }
    ){
        error(R.drawable.nba_icon_no_title)
    }

    val sheetFraction = remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .paint(
                painter = teamLogoPainter,
                contentScale = ContentScale.Crop
            )
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = imageFraction
                        + MIN_BACKGROUND_IMAGE_HEIGHT
                    + sheetFraction.floatValue + 0.1f
                )
                .align(Alignment.TopStart),
            painter = playerPainter,
            contentDescription = stringResource(id = R.string.player_image),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                modifier = Modifier
                    .size(INFO_ICON_SIZE * 2)
                    .weight(1f)
                    .padding(all = SMALL_PADDING)
                    .clickable {
                        sheetFraction.floatValue = sheetFraction.floatValue + 0.1f
                        Log.d("BackgroundContent", "BackgroundContent: sheetFraction.value: ${sheetFraction.floatValue}")
                    }
                ,
                painter = teamLogoPainter,
                contentDescription = "Team Logo",
            )
            Spacer(modifier = Modifier.weight(8f))
            IconButton(
                modifier = Modifier
                    .padding(all = SMALL_PADDING)
                    .weight(1f)
                ,
                onClick = {
//                    onCloseClicked()
                    sheetFraction.floatValue = sheetFraction.floatValue - 0.1f
                    Log.d("BackgroundContent", "BackgroundContent: sheetFraction.value: ${sheetFraction.floatValue}")
                }
            ) {
                Icon(
                    modifier = Modifier.size(INFO_ICON_SIZE),
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close_icon),
                    tint = tintColor
                )
            }
        }
    }
}

@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val fraction = bottomSheetState.progress
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == Collapsed && targetValue == Collapsed -> 1f
            currentValue == Expanded && targetValue == Expanded -> 0f
            currentValue == Collapsed && targetValue == Expanded -> 1f - fraction
            currentValue == Expanded && targetValue == Collapsed -> 0f + fraction
            else -> fraction
        }
    }
