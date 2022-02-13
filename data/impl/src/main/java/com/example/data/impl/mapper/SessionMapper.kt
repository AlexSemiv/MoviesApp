package com.example.data.impl.mapper

import com.example.common.domain.Mapper
import com.example.data.impl.local.model.NewSessionStored
import com.example.data.impl.remote.model.session_new.NewSessionResponse
import javax.inject.Inject

class SessionMapper @Inject constructor(): Mapper<NewSessionResponse, NewSessionStored> {
    override fun to(
        input: NewSessionResponse
    ): NewSessionStored = NewSessionStored(
        id = input.id
    )

    override fun from(
        output: NewSessionStored
    ): NewSessionResponse {
        TODO("No implementation")
    }
}