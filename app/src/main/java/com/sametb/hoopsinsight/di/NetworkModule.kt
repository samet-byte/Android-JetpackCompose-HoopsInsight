package com.sametb.hoopsinsight.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sametb.hoopsinsight.data.local.db.PlayerDatabase
import com.sametb.hoopsinsight.data.remote.NBAApi
import com.sametb.hoopsinsight.data.repo.RemoteDataSourceImpl
import com.sametb.hoopsinsight.domain.repo.IRemoteDataSource
import com.sametb.hoopsinsight.util.constants.ApiConstants.CONTENT_TYPE
import com.sametb.hoopsinsight.util.constants.ApiConstants.EMULATOR_LOCAL_BASE_URL
import com.sametb.hoopsinsight.util.constants.ApiConstants.LOCAL_BASE_URL
import com.sametb.hoopsinsight.util.constants.decideLocalBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/*
* Hoops Insight.com.sametb.hoopsinsight.di
* Created by SAMET BAYAT 
* on 2.02.2024 at 10:12 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient
    ): Retrofit {

        val contentType = MediaType.get(CONTENT_TYPE)

        return Retrofit.Builder()
            .baseUrl(
                decideLocalBaseUrl()
//                EMULATOR_LOCAL_BASE_URL
//                LOCAL_BASE_URL
            )
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideNBAApi(retrofit: Retrofit): NBAApi =
        retrofit.create(NBAApi::class.java)


    @Provides
    @Singleton
    fun provideRemoteDataSource(
        nbaApi: NBAApi,
        playerDatabase: PlayerDatabase
    ) : IRemoteDataSource =
        RemoteDataSourceImpl(nbaApi, playerDatabase)

}

/**
 *     OkHttp Client automatically handles caching  for us
 *     header(
 *             name = HttpHeaders.CacheControl,
 *             value = "public, max-age=$oneYearInSeconds, immutable"
 *     )
 */