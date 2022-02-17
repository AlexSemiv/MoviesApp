package com.example.auth.impl.ui.state

class UsernameState : TextFieldState() {
    override fun isTextValid(text: String): Boolean {
        return text.isNotBlank() && !text.contains(' ')
    }

    override fun errorMessage(input: String): String {
        return "Username is invalid."
    }
}