package com.aydar.data.di

import android.content.Context
import com.aydar.data.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class StorageModule {

    @Provides
    fun providePrefs(@ApplicationContext context: Context) = Preferences(context)
}