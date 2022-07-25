package com.intuit.catdemo.data.repository

import com.intuit.catdemo.data.source.DataManager
import com.intuit.catdemo.data.source.remote.ApiInterface
import com.intuit.catdemo.domain.model.CatBreed
import com.intuit.catdemo.domain.repository.breed.BreedListingRepository
import javax.inject.Inject

class BreedListingRepositoryImpl @Inject constructor(private val dataManager: DataManager) : BreedListingRepository {
    override suspend fun getBreedList(pageNo : Int): List<CatBreed> {
        return dataManager.getBreedList(pageNo)
    }
}