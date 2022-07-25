package com.intuit.catdemo.data.source

import com.intuit.catdemo.data.source.remote.ApiInterface
import com.intuit.catdemo.domain.model.CatBreed
import javax.inject.Inject

class AppDataManager @Inject constructor(private val apiService : ApiInterface) : DataManager {
    override suspend fun getBreedList(pageNo : Int): List<CatBreed> {
        return apiService.getBreedList(pageNo)
    }
}