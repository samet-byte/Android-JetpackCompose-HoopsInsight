package com.sametb.hoopsinsight.di

import android.content.Context
import androidx.room.Room
import com.sametb.hoopsinsight.data.local.PlayerDatabase
import com.sametb.hoopsinsight.util.constants.RoomConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


/*
* Hoops Insight.com.sametb.hoopsinsight.di
* Created by SAMET BAYAT 
* on 1.02.2024 at 6:46 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Module
@InstallIn(Singleton::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context    // dagger hilt will provide context
    ) =
        Room.databaseBuilder(
            context,
            PlayerDatabase::class.java,
            RoomConstants.PLAYER_DATABASE
        ).build()

}