package com.sametb.hoopsinsight.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sametb.hoopsinsight.data.local.db.PlayerDatabase
import com.sametb.hoopsinsight.util.constants.RoomConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/*
* Hoops Insight.com.sametb.hoopsinsight.di
* Created by SAMET BAYAT 
* on 1.02.2024 at 6:46 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context    // dagger hilt will provide context
    ) : PlayerDatabase {
         return  Room.databaseBuilder(
            context,
            PlayerDatabase::class.java,
            RoomConstants.PLAYER_DATABASE
        ).build()
    }


}