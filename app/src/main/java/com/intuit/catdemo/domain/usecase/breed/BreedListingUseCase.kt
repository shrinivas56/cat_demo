package com.intuit.catdemo.domain.usecase.breed

import com.intuit.catdemo.common.Constants
import com.intuit.catdemo.domain.model.CatBreed
import com.intuit.catdemo.domain.repository.breed.BreedListingRepository
import com.intuit.catdemo.domain.usecase.base.UseCase
import javax.inject.Inject

class BreedListingUseCase @Inject constructor(private val breedListingRepository : BreedListingRepository) : UseCase<List<CatBreed>>() {
    override suspend fun run(request: String?, params: Any?): List<CatBreed>? {
        return when(request){
            Constants.FETCH_BREEDS ->  fetchBreeds(params as Int)
            else -> null
        }
    }

    private suspend fun fetchBreeds(pageNo: Int): List<CatBreed>{
        return breedListingRepository.getBreedList(pageNo)
    }
}