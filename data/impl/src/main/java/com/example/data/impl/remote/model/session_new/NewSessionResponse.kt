package com.example.data.impl.remote.model.session_new

import com.example.common.domain.auth.Session
import com.google.gson.annotations.SerializedName

data class NewSessionResponse(
    @SerializedName("session_id")
    val id: String,
    @SerializedName("success")
    val isSuccess: Boolean
)