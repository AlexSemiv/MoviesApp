package com.example.moviesapp.di

import androidx.compose.runtime.compositionLocalOf
import com.example.common.Destinations
import com.example.common.di.CommonProvider
import com.example.data.api.DataProvider

interface AppProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("AppProvider no found!") }