package com.example.common.domain.auth

import com.example.common.domain.Repository
import com.example.common.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository: Repository {

    suspend fun createSessionLoginPassword(username: String, password: String): Flow<Resource<Session>> //Flow<Resource<RequestToken>>

    suspend fun deleteSession(sessionId: String): Boolean
}