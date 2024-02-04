package com.sametb.hoopsinsight.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sametb.hoopsinsight.data.repo.Repository
import com.sametb.hoopsinsight.domain.model.player_paging.Player
import com.sametb.hoopsinsight.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
* Hoops Insight.com.sametb.hoopsinsight.presentation.screens.search
* Created by SAMET BAYAT 
* on 4.02.2024 at 4:05 AM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

// tip: ViewModel can survive configuration changes

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
            val  searchQuery = _searchQuery

    private val _searchResults = MutableStateFlow<PagingData<Player>>(PagingData.empty())
    val searchResults = _searchResults

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchPlayers(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.searchPlayersUseCase(query = query).cachedIn(viewModelScope).collect {
                _searchResults.value = it
            }
        }
    }

}