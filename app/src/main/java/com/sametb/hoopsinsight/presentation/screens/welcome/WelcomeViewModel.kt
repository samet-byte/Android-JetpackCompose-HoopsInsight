package com.sametb.hoopsinsight.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sametb.hoopsinsight.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.welcome
* Created by SAMET BAYAT 
* on 2.02.2024 at 6:22 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO){
            useCases.saveOnBoardingUseCase(completed = completed)
        }
    }
}