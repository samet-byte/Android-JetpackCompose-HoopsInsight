package com.sametb.hoopsinsight.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.domain.use_cases.UseCases
import com.sametb.hoopsinsight.util.constants.NavConstants.DETAILS_ARGUMENT_ID_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.details
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:51 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
): ViewModel()  {

    private val _player: MutableStateFlow<Player?> = MutableStateFlow(null)
             val player: StateFlow<Player?> = _player
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<Int>(DETAILS_ARGUMENT_ID_KEY)
            _player.value = id?.let { useCases.getSelectedPlayerUseCase(id = it) }
            _player.value?.let {
//                Log.d("DetailsScreenViewModel", "init: ${it.info.DISPLAY_FIRST_LAST}")
            }
        }
    }

// once it triggered, it's not going to be triggered again, even after configuration changes
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette

    fun generateColorPalette() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.GenerateColorPalette)
        }
    }

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }

}

sealed class UiEvent {
    object GenerateColorPalette: UiEvent()
}