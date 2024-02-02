@file:OptIn(ExperimentalPagerApi::class)

package com.sametb.hoopsinsight.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.sametb.hoopsinsight.domain.model.OnBoardingPage
import com.sametb.hoopsinsight.nav.Screen
import com.sametb.hoopsinsight.ui.theme.activeIndicatorAndButtonColor
import com.sametb.hoopsinsight.ui.theme.basketballFontFamily
import com.sametb.hoopsinsight.ui.theme.textColor
import com.sametb.hoopsinsight.ui.theme.welcomeScreenBackgroundColor
import com.sametb.hoopsinsight.util.constants.PAGING_INDICATOR_SPACING
import com.sametb.hoopsinsight.util.constants.PAGING_INDICATOR_WIDTH
import com.sametb.hoopsinsight.util.constants.WELCOME_SCREEN_PAGE_COUNT


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.welcome
* Created by SAMET BAYAT 
* on 1.02.2024 at 10:49 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

val pages = listOf(
    OnBoardingPage.FirstPage,
    OnBoardingPage.SecondPage,
    OnBoardingPage.ThirdPage
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel() // from hilt nav compose
) {

    val pagerState = rememberPagerState() // default page is 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = welcomeScreenBackgroundColor(darkTheme)),
    ) {
        // cmd+p to see the all parameters
        HorizontalPager(
            count = WELCOME_SCREEN_PAGE_COUNT,
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .weight(10f)
        ) { p ->
            PagerScreen(pages[p], darkTheme)
            
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = activeIndicatorAndButtonColor(darkTheme),
            inactiveColor = textColor(darkTheme, alpha = 0.5f),
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .weight(1f)
        )
        FinishButton(
            modifier = Modifier
                .weight(1f)
            ,
            pagerState = pagerState,
            text = "Let's Hoop!"
        ) {
            navController.popBackStack() // prevent reshow when go back attempted
            navController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnBoardingState(completed = true)
        }

    }

}



@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage,
    darkTheme: Boolean = isSystemInDarkTheme()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = welcomeScreenBackgroundColor(darkTheme)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = onBoardingPage.title,
            modifier = Modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.6f)
        )
        Text(
            text = onBoardingPage.title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = textColor(darkTheme = isSystemInDarkTheme()),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(12.dp)
            ,
            fontFamily = basketballFontFamily

        )
        Text(
            text = onBoardingPage.description,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor(
                darkTheme,
                alpha = 0.5f
            ),
            textAlign = TextAlign.Center,
            fontFamily = basketballFontFamily,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    text: String = "Finish",
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(horizontal = 2*16.dp)
        ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        AnimatedVisibility(visible = pagerState.currentPage == pagerState.pageCount - 1) {
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = activeIndicatorAndButtonColor(isSystemInDarkTheme()),
                )
            ) {
                Text(
                    text = text,
                    color = textColor(
                        darkTheme = isSystemInDarkTheme(),
                        darkThemeColor = Color.Black,
                        lightThemeColor = Color.White
                    ),
                    fontFamily = basketballFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}