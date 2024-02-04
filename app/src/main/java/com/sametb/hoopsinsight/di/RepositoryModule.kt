package com.sametb.hoopsinsight.di

import android.content.Context
import com.sametb.hoopsinsight.data.repo.preferences.DataOperationsImpl
import com.sametb.hoopsinsight.domain.repo.IDataStoreOperations
import com.sametb.hoopsinsight.data.repo.Repository
import com.sametb.hoopsinsight.domain.use_cases.UseCases
import com.sametb.hoopsinsight.domain.use_cases.onboarding.read.ReadOnBoardingUseCase
import com.sametb.hoopsinsight.domain.use_cases.onboarding.save.SaveOnBoardingUseCase
import com.sametb.hoopsinsight.domain.use_cases.players.get_all.GetAllPlayersUseCase
import com.sametb.hoopsinsight.domain.use_cases.search.SearchPlayersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/*
* Hoops Insight.com.sametb.hoopsinsight.di
* Created by SAMET BAYAT 
* on 2.02.2024 at 5:09 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext
        context: Context
    ): IDataStoreOperations {
        return DataOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository), // try to convert it to extension or infix function.
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllPlayersUseCase = GetAllPlayersUseCase(repository),
            searchPlayersUseCase = SearchPlayersUseCase(repository)
        )
    }

}