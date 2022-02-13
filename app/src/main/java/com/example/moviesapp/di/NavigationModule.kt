package com.example.moviesapp.di

import com.example.auth.impl.di.AuthEntryModule
import dagger.Module

@Module(
    includes = [
        AuthEntryModule::class
    ]
)
interface NavigationModule