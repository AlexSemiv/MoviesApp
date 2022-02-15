package com.example.auth.impl.ui.state

class UsernameState : TextFieldState(
    validator = ::isUsernameValid,
    errorMessage = { usernameErrorMessage() }
)

fun isUsernameValid(username: String) = username.isNotBlank()

fun usernameErrorMessage() = "Username is invalid."