package com.example.auth.impl.ui.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.ui.graphics.vector.ImageVector

data class ErrorTextState(
    var text: String = "",
    var isShown: Boolean = false
)
