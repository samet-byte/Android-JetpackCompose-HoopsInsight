package com.sametb.hoopsinsight.domain.use_cases.onboarding.read

import com.sametb.hoopsinsight.data.repo.Repository
import kotlinx.coroutines.flow.Flow


/*
* Hoops Insight.com.sametb.hoopsinsight.use_cases.onboarding.read
* Created by SAMET BAYAT 
* on 2.02.2024 at 6:04 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {  // no need to suspend
        return repository.readOnBoardingState()
    }
}