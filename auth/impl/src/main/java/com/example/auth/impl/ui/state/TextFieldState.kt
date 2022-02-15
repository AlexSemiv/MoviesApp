package com.example.auth.impl.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errorMessage: (String) -> String
) {
    var text by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    fun validate() {
        error = if(isValid() || text.isEmpty()) null else errorMessage(text)
    }

    fun isValid() = validator(text)
}