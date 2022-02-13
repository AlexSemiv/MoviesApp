package com.example.auth.api

import com.example.common.ComposableFeatureEntry

abstract class AuthEntry: ComposableFeatureEntry {

    final override val featureRoute = "authentication"
}