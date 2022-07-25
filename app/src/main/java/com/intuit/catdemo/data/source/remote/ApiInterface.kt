package com.intuit.catdemo.data.source.remote

import com.intuit.catdemo.domain.model.CatBreed
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("breeds?limit=10")
    suspend fun getBreedList(@Query("page") pageNo : Int) : List<CatBreed>
}