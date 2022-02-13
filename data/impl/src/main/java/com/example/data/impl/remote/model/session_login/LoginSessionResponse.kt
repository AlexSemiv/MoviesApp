package com.example.data.impl.remote.model.session_login

import com.google.gson.annotations.SerializedName

data class LoginSessionResponse(
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("request_token")
    val requestToken: String,
    @SerializedName("success")
    val isSuccess: Boolean
)