package com.example.auth.impl.usecase

import com.example.common.domain.auth.AuthenticationRepository
import com.example.common.domain.auth.Session
import com.example.common.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface CreateSession {
    suspend operator fun invoke(
        username: String,
        password: String
    ): Flow<Resource<Session>>
}

class CreateSessionUseCase @Inject constructor(
    private val repository: AuthenticationRepository
): CreateSession {
    override suspend operator fun invoke(
        username: String,
        password: String
    ) = repository.createSessionLoginPassword(
        username = username,
        password = password
    )
}