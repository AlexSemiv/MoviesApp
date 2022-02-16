package com.example.auth.impl.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


abstract class TextFieldState {
    var text by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    abstract fun isTextValid(text: String): Boolean
    abstract fun errorMessage(unputText: String): String

    fun validate() {
        error = if(isValid() || text.isEmpty()) null else errorMessage(text)
    }

    fun isValid() = isTextValid(text)
}