package com.example.auth.impl.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
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
    modifier: Modifier = Modifier,
    username: String,
    error: String?,
    readOnly: Boolean = false,
    onUsernameChanged: (String) -> Unit,
    onImeAction: () -> Unit,
    onClearClick: () -> Unit
) {
    Column {
        TextField(
            modifier = modifier,
            value = username,
            readOnly = readOnly,
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
            trailingIcon = {
              IconButton(onClick = { onClearClick() }) {
                  Icon(imageVector = Icons.Default.Clear, contentDescription = "Clean")
              }
            },
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