package com.example.auth.impl.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.auth.impl.contract.AuthContract
import com.example.auth.impl.ui.state.PasswordState
import com.example.auth.impl.ui.state.UsernameState
import com.example.common.di.annotation.FeatureScoped
import com.example.auth.impl.usecase.CreateSession
import com.example.common.domain.BaseViewModel
import com.example.common.domain.auth.Session
import com.example.common.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
            passwordState = PasswordState()
        )
    }

    override fun handleEvent(event: AuthContract.Event) {
        when (event) {
            is AuthContract.Event.OnAuthSubmit -> {
                loginUser(
                    username = event.username,
                    password = event.password
                )
            }
            is AuthContract.Event.OnUsernameEntering -> {
                setState {
                    copy(
                        usernameState = UsernameState().apply {
                            text = event.text
                        }
                    )
                }
            }
            is AuthContract.Event.OnPasswordEntering -> {
                setState {
                    copy(
                        passwordState = PasswordState().apply {
                            text = event.text
                        }
                    )
                }
            }
            is AuthContract.Event.OnClearTextFields -> {
                setState {
                    copy(
                        usernameState = UsernameState(),
                        passwordState = PasswordState()
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
                .onStart { emit(Resource.Loading()) }
                .onEach {
                    handleData(it)
                }
                .launchIn(this)
        }
    }

    private fun handleData(result: Resource<Session>) {
        when(result) {
            is Resource.Loading -> {
                setState {
                    copy(authState = AuthContract.AuthState.Loading)
                }
            }
            is Resource.Success -> {
                setState {
                    copy(authState = AuthContract.AuthState.Success(session = result.data))
                }
            }
            is Resource.Error -> {
                setState {
                    copy(authState = AuthContract.AuthState.Error)
                }
                setEffect(AuthContract.Effect.ShowError(message = result.message))
            }
        }
    }
}