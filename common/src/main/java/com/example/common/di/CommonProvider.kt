package com.example.common.di

import android.content.Context
import androidx.compose.runtime.compositionLocalOf

interface CommonProvider {
    val context: Context
}

val LocalCommonProvider = compositionLocalOf<CommonProvider> { error("Common provider no found!") }