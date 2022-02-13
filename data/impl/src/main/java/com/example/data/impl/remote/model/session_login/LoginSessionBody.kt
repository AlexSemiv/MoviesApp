package com.example.data.impl.remote.model.session_login

import com.google.gson.annotations.SerializedName

data class LoginSessionBody(
    @SerializedName("password")
    val password: String,
    @SerializedName("request_token")
    val requestToken: String,
    @SerializedName("username")
    val username: String
)