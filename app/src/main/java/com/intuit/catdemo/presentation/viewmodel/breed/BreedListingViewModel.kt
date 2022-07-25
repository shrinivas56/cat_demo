package com.intuit.catdemo.presentation.viewmodel.breed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.intuit.catdemo.common.Constants
import com.intuit.catdemo.domain.model.CatBreed
import com.intuit.catdemo.domain.model.UseCaseResponse
import com.intuit.catdemo.domain.usecase.base.UseCase
import com.intuit.catdemo.domain.usecase.breed.BreedListingUseCase
import com.intuit.catdemo.presentation.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Collections.addAll
import javax.inject.Inject

@HiltViewModel
class BreedListingViewModel @Inject constructor(private val breedListingUseCase: BreedListingUseCase) : BaseViewModel() {
    private val _catBreeds = MutableLiveData<List<CatBreed>>()
    val catBreeds get() = _catBreeds
    private var pageNo = 0;
    private var _isPaginationDataAvailable = true
    val isPaginationDataAvailable get() = _isPaginationDataAvailable

    fun getCatBreeds(){
        isLoading.value = true
        breedListingUseCase.invoke(
            viewModelScope,
            Constants.FETCH_BREEDS,
            pageNo++,
            onResult = object : UseCaseResponse<List<CatBreed>>{
                override fun onSuccess(result: List<CatBreed>) {
                    isLoading.value = false
                    if(result.isEmpty()) _isPaginationDataAvailable = false
                    _catBreeds.value = result
                    /*_catBreeds.value =  _catBreeds.value.apply {
                        this?.addAll(result)
                    }*/
                }

                override fun onError(e: Throwable) {
                    isLoading.value = false
                }
            }
        )
    }
}