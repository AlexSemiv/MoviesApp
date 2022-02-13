package com.example.data.impl.remote.model.session_delete

import com.google.gson.annotations.SerializedName

data class DeleteSessionBody(
    @SerializedName("session_id")
    val sessionId: String
)