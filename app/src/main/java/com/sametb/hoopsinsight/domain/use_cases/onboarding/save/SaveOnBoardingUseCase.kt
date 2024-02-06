package com.sametb.hoopsinsight.domain.use_cases.onboarding.save

import com.sametb.hoopsinsight.data.repo.Repository


/*
* Hoops Insight.com.sametb.hoopsinsight.use_cases.onboarding.save
* Created by SAMET BAYAT 
* on 2.02.2024 at 5:24 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }

}


