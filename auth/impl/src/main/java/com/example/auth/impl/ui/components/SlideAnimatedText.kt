package com.example.auth.impl.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SlideAnimatedText(
    modifier: Modifier = Modifier,
    text: String,
    isShown: Boolean
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = isShown,
        enter = slideInVertically (
            initialOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(durationMillis = 350, easing = FastOutLinearInEasing)
        ),
        exit = slideOutVertically (
            targetOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(durationMillis = 350, easing = FastOutLinearInEasing)
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.error,
            elevation = 4.dp
        ) {
            Text(
                text = text,
                color = MaterialTheme.colors.onError,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}