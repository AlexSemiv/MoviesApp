package com.example.auth.impl.ui.state

class PasswordState: TextFieldState(
    validator = ::isPasswordValid,
    errorMessage = { passwordErrorMessage() }
)

fun isPasswordValid(password: String) = (password.length >= 5 && password.isNotBlank())

fun passwordErrorMessage() = "Password is invalid."