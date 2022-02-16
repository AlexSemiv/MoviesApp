package com.example.auth.impl.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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

/*
@Preview(
    showSystemUi = true
)
@Composable
fun PreviewAuthScreen() {
    MoviesAppTheme {
        AuthScreen()
    }
}*/

@Preview(
    showSystemUi = true
)
@Composable
fun PreviewLoadingAuthScreen() {
    MoviesAppTheme {
        LoadingAuthScreen()
    }
}

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthenticationViewModel,
    navigateFromLoginScreen: (Session) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    val usernameState = uiState.usernameState
    val passwordState = uiState.passwordState

    var shouldShowError by remember { mutableStateOf(false) }
    var errorText by remember { mutableStateOf("") }
    suspend fun showErrorMessage(text: String) {
        errorText = text
        if(!shouldShowError) {
            shouldShowError = true
            delay(3000L)
            shouldShowError = false
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest {
            when(it) {
                is AuthContract.Effect.ShowError -> {
                    showErrorMessage(it.message)
                }
            }
        }
    }

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

    Box(
        modifier = modifier
    ) {
        SlideAnimatedText(
            modifier = Modifier.align(TopCenter),
            text = errorText,
            isShown = shouldShowError
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    16.dp
                )
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Title()

            val localFocusManager = LocalFocusManager.current
            Username(
                username = usernameState.text,
                error = usernameState.error,
                onUsernameChanged = {
                    viewModel.setEvent(
                        AuthContract.Event.OnUsernameEntering(text = it)
                    )
                },
                onImeAction = {
                    localFocusManager.moveFocus(FocusDirection.Down)
                },
                onClearClick = {
                    localFocusManager.clearFocus()
                    viewModel.setEvent(
                        AuthContract.Event.OnClearTextFields
                    )
                }
            )

            Password(
                password = passwordState.text,
                error = passwordState.error,
                onPasswordChanged = {
                    viewModel.setEvent(
                        AuthContract.Event.OnPasswordEntering(text = it)
                    )
                },
                onImeAction = {
                    if (usernameState.isValid() && passwordState.isValid()) {
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
                isEnabled = usernameState.isValid() && passwordState.isValid()
            ) {
                viewModel.setEvent(AuthContract.Event.OnAuthSubmit(
                        username = usernameState.text,
                        password = passwordState.text
                    )
                )
            }


        }

        if (uiState.authState is AuthContract.AuthState.Loading)
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(BottomCenter),
                strokeWidth = 6.dp
            )
    }
}

@Composable
fun LoadingAuthScreen(
    modifier: Modifier = Modifier
) {
    AnimatedShimmerBox(
        modifier = modifier
    ) { brush ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    16.dp
                )
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(5) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = brush,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .height(32.dp)
                        .padding(8.dp)
                )
            }
        }
    }
}