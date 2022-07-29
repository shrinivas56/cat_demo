package com.intuit.catdemo.presentation.ui.breed.listener

import com.intuit.catdemo.domain.model.CatBreed

interface BreedItemClickListener {
    fun onItemClick(catBreed : CatBreed)
}