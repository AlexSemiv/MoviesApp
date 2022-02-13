package com.example.moviesapp.di

import com.example.common.di.CommonProvider
import com.example.data.api.DataProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonProvider::class,
        DataProvider::class
    ],
    modules = [
        NavigationModule::class
    ]
)
interface AppComponent: AppProvider