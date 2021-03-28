package com.aydar.data.di

import android.content.Context
import androidx.room.Room
import com.aydar.data.BestFeedDatabase
import com.aydar.data.dao.FeedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideBestFeedDatabase(@ApplicationContext appContext: Context): BestFeedDatabase {
        return Room.databaseBuilder(
            appContext,
            BestFeedDatabase::class.java,
            "BestFeedDatabase.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideFeedDao(bestFeedDatabase: BestFeedDatabase): FeedDao = bestFeedDatabase.feedDao()
}