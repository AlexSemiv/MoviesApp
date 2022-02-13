package com.example.auth.impl.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.auth.api.AuthEntry
import com.example.common.Destinations
import javax.inject.Inject

class AuthEntryImpl @Inject constructor(): AuthEntry() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        TODO()
    }
}