package com.example.auth.impl.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.auth.impl.R

@Composable
fun Title() {
    Text(
        text = stringResource(id = R.string.sign_in_welcome),
        style = MaterialTheme.typography.h1
    )
}