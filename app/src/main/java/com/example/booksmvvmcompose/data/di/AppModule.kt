package com.example.booksmvvmcompose.data.di

import com.example.booksmvvmcompose.data.BookApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBookApi(): BookApi {
        // Create Retrofit API object & return
        return BookApi.instance
    }

}