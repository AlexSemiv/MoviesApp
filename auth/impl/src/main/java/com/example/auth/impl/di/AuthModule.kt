package com.example.auth.impl.di

import com.example.auth.impl.usecase.CreateSession
import com.example.auth.impl.usecase.CreateSessionUseCase
import dagger.Binds
import dagger.Module

@Module
interface AuthModule {

    @Binds
    fun bindCreateSession(
        impl: CreateSessionUseCase
    ): CreateSession
}