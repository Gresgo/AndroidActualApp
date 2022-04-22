package com.gresgo.aaa.di

import android.app.Application
import com.gresgo.aaa.App
import com.gresgo.core_navigation.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRouter(app: Application): Router = (app as App).router

}