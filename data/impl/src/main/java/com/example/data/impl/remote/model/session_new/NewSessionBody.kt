package com.example.data.impl.remote.model.session_new

import com.google.gson.annotations.SerializedName

data class NewSessionBody(
    @SerializedName("request_token")
    val requestToken: String
)