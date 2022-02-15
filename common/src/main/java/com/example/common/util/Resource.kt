package com.example.common.util

sealed class Resource<T>(
    data: T? = null,
    message: String? = null
) {
    class Success<T>(val data: T): Resource<T>(data)
    class Error<T>(val data: T? = null, val message: String): Resource<T>(data, message)
    class Loading<T>(val data: T? = null): Resource<T>(data)
}
