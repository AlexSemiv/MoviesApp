package com.example.auth.impl.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics

@Composable
fun InfoText(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onCloseClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.End),
            onClick = { onCloseClick() }
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Info icon"
            )
            Text(
                modifier = Modifier.semantics { heading() },
                text = text,
                style = MaterialTheme.typography.h5
            )
        }
    }
}