package com.intuit.catdemo.domain.usecase.base

import com.intuit.catdemo.domain.model.UseCaseResponse
import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

abstract class UseCase<Type> where Type : Any {

    abstract suspend fun run(request: String?, params: Any?): Type?

    fun invoke(
        scope: CoroutineScope,
        request: String?,
        params: Any?,
        onResult: UseCaseResponse<Type>?,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        scope.launch {
            try {
                withContext(dispatcher) {
                    run(request, params)
                }?.let {
                    onResult?.onSuccess(it)
                } ?:run{
                    onResult?.onError(NoSuchFieldException())
                }
            } catch (e: CancellationException) {
                e.printStackTrace()
                onResult?.onError(e)
            }catch (e: Exception){
                e.printStackTrace()
                onResult?.onError(e)
            }
        }
    }
}