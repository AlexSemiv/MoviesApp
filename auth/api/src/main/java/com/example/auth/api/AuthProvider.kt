package com.example.auth.api

import androidx.compose.runtime.compositionLocalOf

interface AuthProvider

val LocalAuthProvider = compositionLocalOf<AuthProvider> { error("AuthProvider no found!") }