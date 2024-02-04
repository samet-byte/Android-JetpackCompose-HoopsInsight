package com.sametb.hoopsinsight.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.sametb.hoopsinsight.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.home
* Created by SAMET BAYAT 
* on 3.02.2024 at 1:31 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val getAllPlayers = useCases.getAllPlayersUseCase()
}