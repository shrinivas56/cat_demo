package com.intuit.catdemo.domain.model

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(e: Throwable)

}