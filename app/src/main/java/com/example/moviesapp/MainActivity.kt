package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.di.LocalCommonProvider
import com.example.data.api.LocalDataProvider
import com.example.moviesapp.di.LocalAppProvider
import com.example.moviesapp.ui.Movies
import com.example.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CompositionLocalProvider(
                        LocalAppProvider provides application.appProvider,
                        LocalDataProvider provides application.appProvider,
                        LocalCommonProvider provides application.appProvider
                    ) {
                        Movies()
                    }
                }
            }
        }
    }
}