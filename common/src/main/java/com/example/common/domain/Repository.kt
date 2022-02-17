package com.example.common.domain

import org.json.JSONObject
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
        } else
            throw IllegalStateException(
                // TODO("Handle Json throw")
                JSONObject(response.errorBody()?.string() ?: "").getString("status_message")
            )
    }
}