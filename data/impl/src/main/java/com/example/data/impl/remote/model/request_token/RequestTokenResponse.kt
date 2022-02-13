package com.example.data.impl.remote.model.request_token

import com.google.gson.annotations.SerializedName

data class RequestTokenResponse(
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("request_token")
    val value: String,
    @SerializedName("success")
    val isSuccess: Boolean
)