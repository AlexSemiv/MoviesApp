package com.example.data.impl.repository

import com.example.common.domain.Mapper
import com.example.common.util.Resource
import com.example.common.domain.auth.AuthenticationRepository
import com.example.common.domain.auth.Session
import com.example.data.impl.local.model.NewSessionStored
import com.example.data.impl.remote.MovieApi
import com.example.data.impl.remote.model.session_login.LoginSessionBody
import com.example.data.impl.remote.model.session_new.NewSessionBody
import com.example.data.impl.remote.model.session_new.NewSessionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val mapper: Mapper<NewSessionResponse, NewSessionStored>
): AuthenticationRepository {

    override suspend fun createSessionLoginPassword(
        username: String,
        password: String
    ): Flow<Resource<Session>> = flow {
        try {
            emit(Resource.Loading())
            val requestToken = handleRetrofitResponse {
                api.getRequestToken()
            }
            val loginRequestBody = LoginSessionBody(
                username = username,
                password = password,
                requestToken = requireNotNull(requestToken?.value)
            )
            val loginResponse = handleRetrofitResponse {
                api.createSessionLoginPassword(body = loginRequestBody)
            }
            val newSessionBody = NewSessionBody(
                requestToken = requireNotNull(loginResponse?.requestToken)
            )
            val newSession = requireNotNull(handleRetrofitResponse {
                api.createSession(body = newSessionBody)
            })
            if(newSession.isSuccess)
                emit(Resource.Success(data = mapper.to(newSession)))
            else
                emit(Resource.Error(message = "Unknown error"))

            // save session id?
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown error"))
        }
    }

    override suspend fun deleteSession(sessionId: String): Boolean {
        TODO("Not yet implemented")
    }
}