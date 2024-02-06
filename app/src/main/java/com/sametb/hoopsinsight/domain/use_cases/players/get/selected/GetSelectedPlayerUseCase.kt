package com.sametb.hoopsinsight.domain.use_cases.players.get.selected

import com.sametb.hoopsinsight.data.repo.Repository


/*
* Hoops Insight.com.sametb.hoopsinsight.domain.use_cases.players.get.selected
* Created by SAMET BAYAT 
* on 4.02.2024 at 6:46 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class GetSelectedPlayerUseCase(
    private val repository: Repository,
){
    suspend operator fun invoke(id: Int) = repository.getSelectedPlayer(id = id)
}
