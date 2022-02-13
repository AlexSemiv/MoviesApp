package com.example.common.domain

import retrofit2.Response
import java.lang.IllegalStateException

interface Repository {
    suspend fun <T> handleRetrofitResponse(
        request: suspend () -> Response<T>
    ): T? {
        val response = request.invoke()
        return if (response.isSuccessful) {
            when(response.code()) {
                200 -> response.body()
                else -> null
            }
        } else throw IllegalStateException(
            when(response.code()) {
                401 -> "Invalid API key: You must be granted a valid key."
                404 -> "The resource you requested could not be found."
                else -> "Unknown error"
            }
        )
    }
}