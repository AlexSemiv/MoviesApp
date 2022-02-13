package com.example.moviesapp

import android.app.Application
import com.example.common.di.DaggerCommonComponent
import com.example.data.impl.di.DaggerDataComponent
import com.example.moviesapp.di.AppProvider
import com.example.moviesapp.di.DaggerAppComponent

class MoviesApplication: Application() {

    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()

        val commonProvider = DaggerCommonComponent.builder()
            .context(this)
            .build()
        appProvider = DaggerAppComponent.builder()
            .commonProvider(commonProvider)
            .dataProvider(
                DaggerDataComponent.builder()
                    .commonProvider(commonProvider)
                    .build()
            )
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as MoviesApplication).appProvider