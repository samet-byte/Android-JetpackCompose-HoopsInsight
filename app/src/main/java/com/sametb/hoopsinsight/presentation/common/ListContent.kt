package com.sametb.hoopsinsight.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.sametb.hoopsinsight.R
import com.sametb.hoopsinsight.domain.model.player_paging.Luka_Dončić
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.nav.Screen
import com.sametb.hoopsinsight.presentation.components.RatingWidget
import com.sametb.hoopsinsight.presentation.components.ShimmerEffect
import com.sametb.hoopsinsight.ui.theme.ITEM_HEIGHT
import com.sametb.hoopsinsight.ui.theme.LARGE_PADDING
import com.sametb.hoopsinsight.ui.theme.MEDIUM_PADDING
import com.sametb.hoopsinsight.ui.theme.SMALL_PADDING
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.ui.theme.cardInfoBgColor
import com.sametb.hoopsinsight.util.constants.randomRatingWithPoint5


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.common
* Created by SAMET BAYAT 
* on 3.02.2024 at 4:19 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Composable
fun ListContent(
    players: LazyPagingItems<Player>,
    navController: NavHostController,
) {
//    Log.d("ListContent", "ListContent Load State: ${players.loadState.toString()}")
    val resultIsLoaded = handlePagingResult(players = players)

    if (resultIsLoaded) {
        DisplayLazyPlayersList(
            players = players,
            navController = navController,
        )
    }
}

@Composable
private fun DisplayLazyPlayersList(
    players: LazyPagingItems<Player>,
    navController: NavHostController,
) {
    LazyColumn(
        contentPadding = PaddingValues(MEDIUM_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {

        items(
            items = players,
            key = { player -> player.id }
        ) { player ->
            player?.let {
                PlayerItem(
                    player = it,
                    navController = navController
                )
            }
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun PlayerItem(
    player: Player,
    navController: NavHostController,
) {

    val painter = rememberImagePainter(data = player.info.IMAGE){
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_placeholder)
    }

    val randomRating = randomRatingWithPoint5()

    Box(
        modifier = Modifier
            .height(ITEM_HEIGHT)
            .clickable { navController.navigate(Screen.Details.passId(id = player.id)) }
        ,
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = Shapes().large,
        ) {
            Image(
                painter = painter,
                contentDescription = player.info.DISPLAY_FIRST_LAST,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                ,
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(.4f)
                .fillMaxWidth(),
//            color = Color.Blue.copy(alpha = ContentAlpha.medium),
            color = cardInfoBgColor(),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MEDIUM_PADDING)
                    ,
            ) {
                Text(
                    text = "#${player.info.JERSEY} | ${player.info.DISPLAY_LAST_COMMA_FIRST}",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = Bold,
                    fontFamily = basketballFontFamily,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis // ... if text is too long
                )
                Text(
                    text = player.cmsBio ?: "No bio available",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    fontFamily = basketballFontFamily,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis // ... if text is too long
                )
                Row(
                    modifier = Modifier
                        .padding(SMALL_PADDING)
                    ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(SMALL_PADDING),
                        rating = randomRating // TODO: 3.02.2024 get rating from player
                    )
                    Text(
                        text = "($randomRating)",
                        color = Color.White,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontFamily = basketballFontFamily,
                    )
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(
    players: LazyPagingItems<Player>,
): Boolean {
    players.apply {
        val error = when {
            loadState.refresh is androidx.paging.LoadState.Error -> loadState.refresh as androidx.paging.LoadState.Error
            loadState.append is androidx.paging.LoadState.Error -> loadState.append as androidx.paging.LoadState.Error
            loadState.prepend is androidx.paging.LoadState.Error -> loadState.prepend as androidx.paging.LoadState.Error
            else -> null
        }
        return when {
            loadState.refresh is androidx.paging.LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            error != null -> {
                EmptyScreen(error = error)
                false
            }
            players.itemCount < 1 -> {
                EmptyScreen() // empty search screen
                false
            }
            else -> true
        }
    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlayerItemPreview() {
    PlayerItem(
        player = Luka_Dončić,
        navController = NavHostController(LocalContext.current)
    )
}