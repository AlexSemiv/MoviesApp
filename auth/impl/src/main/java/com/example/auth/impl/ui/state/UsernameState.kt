package com.example.auth.impl.ui.state

class UsernameState : TextFieldState() {
    override fun isTextValid(text: String): Boolean {
        return text.isNotBlank()
    }

    override fun errorMessage(unputText: String): String {
        return "Username is invalid."
    }
}