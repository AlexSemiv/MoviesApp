package com.example.data.impl.remote

import com.example.data.impl.remote.model.request_token.RequestTokenResponse
import com.example.data.impl.remote.model.session_delete.DeleteSessionBody
import com.example.data.impl.remote.model.session_delete.DeleteSessionResponse
import com.example.data.impl.remote.model.session_login.LoginSessionBody
import com.example.data.impl.remote.model.session_login.LoginSessionResponse
import com.example.data.impl.remote.model.session_new.NewSessionBody
import com.example.data.impl.remote.model.session_new.NewSessionResponse
import retrofit2.Response
import retrofit2.http.*

interface MovieApi {

    companion object {
        const val BASE_URL3 = "https://api.themoviedb.org/3/"
        private const val API_KEY = "6ccd72a2a8fc239b13f209408fc31c33"
    }

    @GET("authentication/token/new")
    suspend fun getRequestToken(
        @Query("api_key")
        key: String = API_KEY
    ): Response<RequestTokenResponse>

    @POST("authentication/token/validate_with_login")
    suspend fun createSessionLoginPassword(
        @Query("api_key")
        key: String = API_KEY,
        @Body
        body: LoginSessionBody
    ): Response<LoginSessionResponse>

    @POST("authentication/session/new")
    suspend fun createSession(
        @Query("api_key")
        key: String = API_KEY,
        @Body
        body: NewSessionBody
    ): Response<NewSessionResponse>

    @DELETE("authentication/session")
    suspend fun deleteSession(
        @Query("api_key")
        key: String = API_KEY,
        @Body
        body: DeleteSessionBody
    ): Response<DeleteSessionResponse>
}