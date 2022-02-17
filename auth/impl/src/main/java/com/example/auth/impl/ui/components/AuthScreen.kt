package com.example.auth.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auth.impl.contract.AuthContract
import com.example.auth.impl.viewmodel.AuthenticationViewModel
import com.example.common.domain.auth.Session
import com.example.common.ui.theme.MoviesAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthenticationViewModel,
    navigateFromLoginScreen: (Session) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val usernameState = uiState.usernameState
    val passwordState = uiState.passwordState
    val errorTextState = uiState.errorTextState

    val isLoading = uiState.authState is AuthContract.AuthState.Loading
    val isSignButtonEnabled = usernameState.isValid && passwordState.isValid && !isLoading

    LaunchedEffect(key1 = true) {
        viewModel.uiState.collectLatest {
            when(val state = it.authState) {
                is AuthContract.AuthState.Success -> {
                    navigateFromLoginScreen(state.session)
                }
                else -> Unit
            }
        }
    }

    AnimatedShimmerBox(
        modifier = modifier
    ) { animatedBrush, defaultBrush ->

        TopSlideAnimatedText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .align(TopCenter),
            text = errorTextState.text,
            isShown = errorTextState.isShown,
            onCloseClick = {
                viewModel.setEvent(
                    AuthContract.Event.OnCloseErrorText
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Title()

            val localFocusManager = LocalFocusManager.current
            Username(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = if(isLoading) animatedBrush else defaultBrush,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                    ),
                username = usernameState.text,
                error = usernameState.error,
                readOnly = isLoading,
                onUsernameChanged = {
                    viewModel.setEvent(
                        AuthContract.Event.OnUsernameEntering(text = it)
                    )
                },
                onImeAction = {
                    localFocusManager.moveFocus(FocusDirection.Down)
                },
                onClearClick = {
                    if(!isLoading) {
                        localFocusManager.clearFocus()
                        viewModel.setEvent(
                            AuthContract.Event.OnClearTextFields
                        )
                    }
                }
            )

            Password(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = if(isLoading) animatedBrush else defaultBrush,
                        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
                    ),
                password = passwordState.text,
                error = passwordState.error,
                readOnly = isLoading,
                onPasswordChanged = {
                    viewModel.setEvent(
                        AuthContract.Event.OnPasswordEntering(text = it)
                    )
                },
                onImeAction = {
                    if (isSignButtonEnabled) {
                        localFocusManager.clearFocus()
                        viewModel.setEvent(
                            AuthContract.Event.OnAuthSubmit(
                                username = usernameState.text,
                                password = passwordState.text
                            )
                        )
                    }
                }
            )

            SignInButton(
                modifier = Modifier.fillMaxWidth(),
                isEnabled = isSignButtonEnabled
            ) {
                localFocusManager.clearFocus()
                viewModel.setEvent(
                    AuthContract.Event.OnAuthSubmit(
                        username = usernameState.text,
                        password = passwordState.text
                    )
                )
            }
        }
    }
}