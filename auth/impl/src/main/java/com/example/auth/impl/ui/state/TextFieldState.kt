package com.example.auth.impl.ui.state

import androidx.compose.runtime.*
import kotlin.properties.Delegates


abstract class TextFieldState {
    abstract fun isTextValid(text: String): Boolean
    abstract fun errorMessage(input: String): String

    var text: String by Delegates.observable(
        initialValue = ""
    ) { _, _, newValue ->
        isValid = isTextValid(text)
        error = if(isValid || newValue.isEmpty()) null else errorMessage(newValue)
    }

    var error: String? = null
        private set

    var isValid: Boolean = false
        private set
}