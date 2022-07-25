package com.intuit.catdemo.di

import android.content.Context
import com.intuit.catdemo.data.repository.BreedListingRepositoryImpl
import com.intuit.catdemo.data.source.AppDataManager
import com.intuit.catdemo.domain.repository.breed.BreedListingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModules {
    @Singleton
    @Provides
    fun provideBreedListingRepositoryRepository(
        appDataManager: AppDataManager,
    ): BreedListingRepository {
        return BreedListingRepositoryImpl(appDataManager)
    }

}