package com.example.auth.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.auth.api.AuthEntry
import com.example.auth.impl.di.DaggerAuthComponent
import com.example.common.Destinations
import com.example.common.di.injectedViewModel
import com.example.data.api.LocalDataProvider
import javax.inject.Inject

class AuthEntryImpl @Inject constructor(): AuthEntry() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        /*val viewModel = injectedViewModel {
            DaggerAuthComponent.builder()
                .dataProvider(LocalDataProvider.current)
                .build()
                .viewModel
        }
         */

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Auth entry",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}