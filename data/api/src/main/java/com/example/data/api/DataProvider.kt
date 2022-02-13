package com.example.data.api

import androidx.compose.runtime.compositionLocalOf
import com.example.common.domain.auth.AuthenticationRepository

interface DataProvider {
    val authenticationRepository: AuthenticationRepository
}

val LocalDataProvider = compositionLocalOf<DataProvider> { error("Data provider not found!") }