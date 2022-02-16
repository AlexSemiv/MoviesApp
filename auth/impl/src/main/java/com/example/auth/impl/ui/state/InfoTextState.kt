package com.example.auth.impl.ui.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.ui.graphics.vector.ImageVector

data class InfoTextState(
    var text: String = "",
    var icon: ImageVector = Icons.Default.ErrorOutline,
    var isShown: Boolean = false
)
