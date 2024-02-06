package com.sametb.hoopsinsight.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sametb.hoopsinsight.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.splash
* Created by SAMET BAYAT 
* on 2.02.2024 at 6:38 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _onBoardingCompleted = MutableStateFlow(false)
            val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

    init {
        viewModelScope.launch(Dispatchers.IO){
            _onBoardingCompleted.value = useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
            // operator declaration allows us to call `invoke` just by calling the class like `.readOnBoardingUseCase()`
            // stateIn converts Flow to StateFlow
        }
    }
}