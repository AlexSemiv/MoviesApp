package com.example.auth.impl.contract

import com.example.common.domain.UiEffect
import com.example.common.domain.UiEvent
import com.example.common.domain.UiState
import com.example.common.domain.auth.Session

object AuthContract {

    sealed class Event: UiEvent {
        data class OnAuthSubmit(
            val login: String,
            val password: String
        ): Event()
    }

    sealed class Effect: UiEffect {
        data class ShowError(
            val message: String
        ): Effect()
    }

    sealed class AuthState {
        object Idle: AuthState()
        object Loading: AuthState()
        data class Success(val session: Session): AuthState()
        object Error: AuthState()
    }

    data class State(
        val authState: AuthState
    ): UiState
}