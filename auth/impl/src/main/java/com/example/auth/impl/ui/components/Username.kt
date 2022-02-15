package com.example.auth.impl.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.auth.impl.R


@Composable
fun Username(
    username: String,
    error: String?,
    onUsernameChanged: (String) -> Unit,
    onImeAction: () -> Unit
) {
    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            singleLine = true,
            maxLines = 1,
            onValueChange = {
                onUsernameChanged(it)
            },
            label = {
                Text(text = stringResource(id = R.string.hint_username))
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onImeAction()
                }
            ),
            isError = error != null
        )

        error?.let {
            Text(text = it, color = MaterialTheme.colors.error)
        }
    }
}