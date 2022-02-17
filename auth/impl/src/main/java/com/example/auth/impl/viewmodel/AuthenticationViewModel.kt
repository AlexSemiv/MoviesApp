package com.example.auth.impl.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.auth.impl.contract.AuthContract
import com.example.auth.impl.contract.AuthContract.Event.*
import com.example.auth.impl.ui.state.ErrorTextState
import com.example.auth.impl.ui.state.PasswordState
import com.example.auth.impl.ui.state.UsernameState
import com.example.common.di.annotation.FeatureScoped
import com.example.auth.impl.usecase.CreateSession
import com.example.common.domain.BaseViewModel
import com.example.common.domain.auth.Session
import com.example.common.util.Resource
import com.example.common.util.Resource.Error
import com.example.common.util.Resource.Loading
import com.example.common.util.Resource.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@FeatureScoped
class AuthenticationViewModel @Inject constructor(
    private val createSessionUseCase: CreateSession
): BaseViewModel<AuthContract.Event, AuthContract.State, AuthContract.Effect>() {

    override fun createInitialUiState(): AuthContract.State {
        return AuthContract.State(
            authState = AuthContract.AuthState.Idle,
            usernameState = UsernameState(),
            passwordState = PasswordState(),
            errorTextState = ErrorTextState()
        )
    }

    override fun handleEvent(event: AuthContract.Event) {
        when (event) {
            is OnAuthSubmit -> {
                loginUser(
                    username = event.username,
                    password = event.password
                )
            }
            is OnUsernameEntering -> {
                setState {
                    copy(
                        usernameState = UsernameState().apply {
                            text = event.text
                        }
                    )
                }
            }
            is OnPasswordEntering -> {
                setState {
                    copy(
                        passwordState = PasswordState().apply {
                            text = event.text
                        }
                    )
                }
            }
            is OnClearTextFields -> {
                setState {
                    copy(
                        usernameState = UsernameState(),
                        passwordState = PasswordState()
                    )
                }
            }
            is OnCloseErrorText -> {
                setState {
                    copy(
                        errorTextState = ErrorTextState()
                    )
                }
            }
        }
    }

    private fun loginUser(
        username: String,
        password: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            createSessionUseCase.invoke(
                username = username,
                password = password
            )
                .onStart { emit(Loading()) }
                .onEach {
                    handleData(it)
                }
                .launchIn(this)
        }
    }

    private fun handleData(result: Resource<Session>) {
        when(result) {
            is Loading -> {
                setState {
                    copy(authState = AuthContract.AuthState.Loading)
                }
            }
            is Success -> {
                setState {
                    copy(authState = AuthContract.AuthState.Success(session = result.data))
                }
            }
            is Error -> {
                setState {
                    copy(
                        authState = AuthContract.AuthState.Error,
                        errorTextState = ErrorTextState(
                            text = result.message,
                            isShown = true
                        )
                    )
                }
            }
        }
    }
}