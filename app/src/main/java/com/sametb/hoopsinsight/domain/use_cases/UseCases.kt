package com.sametb.hoopsinsight.domain.use_cases

import com.sametb.hoopsinsight.domain.use_cases.onboarding.read.ReadOnBoardingUseCase
import com.sametb.hoopsinsight.domain.use_cases.onboarding.save.SaveOnBoardingUseCase
import com.sametb.hoopsinsight.domain.use_cases.players.get_all.GetAllPlayersUseCase
import com.sametb.hoopsinsight.domain.use_cases.search.SearchPlayersUseCase


/*
* Hoops Insight.com.sametb.hoopsinsight.use_cases
* Created by SAMET BAYAT 
* on 2.02.2024 at 6:17 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllPlayersUseCase: GetAllPlayersUseCase,
    val searchPlayersUseCase: SearchPlayersUseCase,
)
