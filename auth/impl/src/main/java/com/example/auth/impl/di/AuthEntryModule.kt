package com.example.auth.impl.di

import com.example.auth.api.AuthEntry
import com.example.common.FeatureEntry
import com.example.common.di.annotation.FeatureEntryKey
import com.example.auth.impl.ui.AuthEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface AuthEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(AuthEntry::class)
    fun bindAuthEntry(
        entry: AuthEntryImpl
    ): FeatureEntry
}