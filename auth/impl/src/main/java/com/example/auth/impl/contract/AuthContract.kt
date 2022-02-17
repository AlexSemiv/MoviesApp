package com.example.auth.impl.contract

import com.example.auth.impl.ui.state.ErrorTextState
import com.example.auth.impl.ui.state.PasswordState
import com.example.auth.impl.ui.state.UsernameState
import com.example.common.domain.UiEffect
import com.example.common.domain.UiEvent
import com.example.common.domain.UiState
import com.example.common.domain.auth.Session

object AuthContract {

    sealed class Event: UiEvent {
        data class OnAuthSubmit(
            val username: String,
            val password: String
        ): Event()
        data class OnUsernameEntering(
            val text: String
        ): Event()
        data class OnPasswordEntering(
            val text: String
        ): Event()
        object OnClearTextFields: Event()
        object OnCloseErrorText: Event()
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
        val authState: AuthState,
        val usernameState: UsernameState,
        val passwordState: PasswordState,
        val errorTextState: ErrorTextState
    ): UiState
}