package com.example.auth.impl.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


abstract class TextFieldState {
    abstract fun isTextValid(text: String): Boolean
    abstract fun errorMessage(unputText: String): String

    var text by mutableStateOf("")
        private set
    var error by mutableStateOf<String?>(null)
        private set

    fun setTextValue(value: String) {
        text = value
        error = if(isValid() || text.isEmpty()) null else errorMessage(text)
    }

    fun isValid() = isTextValid(text)
}