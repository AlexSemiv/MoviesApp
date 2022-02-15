package com.example.moviesapp

import android.app.Application
import com.example.common.di.CommonProvider
import com.example.common.di.DaggerCommonComponent
import com.example.data.api.DataProvider
import com.example.data.impl.di.DaggerDataComponent
import com.example.moviesapp.di.AppProvider
import com.example.moviesapp.di.DaggerAppComponent

class MoviesApplication: Application() {

    var appProvider: AppProvider? = null
    var commonProvider: CommonProvider? = null
    var dataProvider: DataProvider? = null

    override fun onCreate() {
        super.onCreate()

        commonProvider = DaggerCommonComponent.builder()
            .context(this)
            .build()
        dataProvider = DaggerDataComponent.builder()
            //.commonProvider(commonProvider)
            .build()
        appProvider = DaggerAppComponent.builder()
            //.commonProvider(commonProvider)
            //.dataProvider(dataProvider)
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as MoviesApplication).appProvider ?: error("Nullable appProvider")

val Application.commonProvider: CommonProvider
    get() = (this as MoviesApplication).commonProvider ?: error("Nullable commonProvider")

val Application.dataProvider: DataProvider
    get() = (this as MoviesApplication).dataProvider ?: error("Nullable dataProvider")