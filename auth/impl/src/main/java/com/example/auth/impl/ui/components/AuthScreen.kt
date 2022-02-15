package com.example.auth.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auth.impl.ui.AnimatedShimmerBox
import com.example.auth.impl.ui.state.PasswordState
import com.example.auth.impl.ui.state.UsernameState
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
) {
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
            val usernameState by remember { mutableStateOf(UsernameState()) }
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

            val passwordState by remember { mutableStateOf(PasswordState()) }
            Password(
                password = passwordState.text,
                error = passwordState.error,
                onPasswordChanged = {
                    passwordState.text = it
                    passwordState.validate()
                },
                onImeAction = {
                    if (usernameState.isValid() && passwordState.isValid())
                        localFocusManager.clearFocus()
                }
            )

            SignInButton(
                isEnabled = usernameState.isValid() && passwordState.isValid()
            )
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