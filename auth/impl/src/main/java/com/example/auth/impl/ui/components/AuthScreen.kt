package com.example.auth.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auth.impl.contract.AuthContract
import com.example.auth.impl.ui.state.PasswordState
import com.example.auth.impl.ui.state.UsernameState
import com.example.auth.impl.viewmodel.AuthenticationViewModel
import com.example.common.ui.theme.MoviesAppTheme

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
    viewModel: AuthenticationViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val usernameState = uiState.usernameState
    val passwordState = uiState.passwordState

    Box(
        modifier = modifier
    ) {
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
                    usernameState.text = it
                    usernameState.validate()
                },
                onImeAction = {
                    localFocusManager.moveFocus(FocusDirection.Down)
                }
            )

            Password(
                password = passwordState.text,
                error = passwordState.error,
                onPasswordChanged = {
                    passwordState.text = it
                    passwordState.validate()
                },
                onImeAction = {
                    if (usernameState.isValid() && passwordState.isValid()) {
                        localFocusManager.clearFocus()
                        viewModel.setEvent(AuthContract.Event.OnAuthSubmit(
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