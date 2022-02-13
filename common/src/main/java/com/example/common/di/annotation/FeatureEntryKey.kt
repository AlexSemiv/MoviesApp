package com.example.common.di.annotation

import com.example.common.FeatureEntry
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)