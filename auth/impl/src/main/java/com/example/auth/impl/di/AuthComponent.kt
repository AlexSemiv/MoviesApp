package com.example.auth.impl.di

import com.example.auth.api.AuthProvider
import com.example.common.di.annotation.FeatureScoped
import com.example.auth.impl.viewmodel.AuthenticationViewModel
import com.example.data.api.DataProvider
import dagger.Component

@FeatureScoped
@Component(
    modules = [
        AuthModule::class
    ],
    dependencies = [
        DataProvider::class
    ]
)
interface AuthComponent: AuthProvider {

    val viewModel: AuthenticationViewModel
}