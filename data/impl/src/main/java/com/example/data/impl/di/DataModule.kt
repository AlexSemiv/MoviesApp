package com.example.data.impl.di

import com.example.common.domain.Mapper
import com.example.common.domain.auth.AuthenticationRepository
import com.example.data.impl.local.model.NewSessionStored
import com.example.data.impl.mapper.SessionMapper
import com.example.data.impl.remote.model.session_new.NewSessionResponse
import com.example.data.impl.repository.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class
    ]
)
interface DataModule {

    @Binds
    @Singleton
    fun bindAuthenticationRepository(
        impl: AuthenticationRepositoryImpl
    ): AuthenticationRepository

    @Binds
    @Singleton
    fun bindSessionMapper(
        impl: SessionMapper
    ): Mapper<NewSessionResponse, NewSessionStored>
}