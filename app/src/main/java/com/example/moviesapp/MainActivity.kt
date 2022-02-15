package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.example.common.di.LocalCommonProvider
import com.example.data.api.LocalDataProvider
import com.example.moviesapp.di.LocalAppProvider
import com.example.moviesapp.ui.Movies
import com.example.common.ui.theme.MoviesAppTheme

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
                        LocalDataProvider provides application.dataProvider,
                        LocalCommonProvider provides application.commonProvider
                    ) {
                        Movies()
                    }
                }
            }
        }
    }
}