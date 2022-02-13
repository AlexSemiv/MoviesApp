package com.example.auth.impl.viewmodel

import androidx.lifecycle.ViewModel
import com.example.common.di.annotation.FeatureScoped
import com.example.auth.impl.usecase.CreateSession
import javax.inject.Inject

@FeatureScoped
class AuthenticationViewModel @Inject constructor(
    private val createSessionUseCase: CreateSession
): ViewModel() {

}