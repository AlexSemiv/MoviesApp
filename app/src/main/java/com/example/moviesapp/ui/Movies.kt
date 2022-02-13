package com.example.moviesapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.auth.api.AuthEntry
import com.example.common.find
import com.example.moviesapp.di.LocalAppProvider

@Composable
fun Movies() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val authScreen = destinations.find<AuthEntry>()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = authScreen.featureRoute
        ) {
            with(authScreen) {
                composable(
                    navController = navController,
                    destinations = destinations
                )
            }
        }
    }
}