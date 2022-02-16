package com.example.auth.impl.ui.state

class PasswordState: TextFieldState() {
    override fun isTextValid(text: String): Boolean {
        return text.length >= 5 && text.isNotBlank()
    }

    override fun errorMessage(unputText: String): String {
        return "Password is invalid."
    }
}