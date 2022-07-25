package com.intuit.catdemo.domain.repository.breed

import com.intuit.catdemo.domain.model.CatBreed

interface  BreedListingRepository {
    suspend fun getBreedList(pageNo : Int) : List<CatBreed>
}