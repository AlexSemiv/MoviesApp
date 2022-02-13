package com.example.data.impl.remote.model.session_delete

import com.google.gson.annotations.SerializedName

data class DeleteSessionResponse(
    @SerializedName("success")
    val isSuccess: Boolean
)