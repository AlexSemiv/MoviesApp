package com.example.data.impl.di

import com.example.data.api.DataProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class
    ]
)
interface DataComponent: DataProvider