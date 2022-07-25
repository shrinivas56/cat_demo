package com.intuit.catdemo.presentation.viewmodel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    protected val isLoading = MutableLiveData(false)
    val getIsLoading get() = isLoading

    protected val showMessage = MutableLiveData<String?>()
    val getShowMessage get() = showMessage

    protected val isError = MutableLiveData<Throwable>()
    val getIsError get() = isError
}