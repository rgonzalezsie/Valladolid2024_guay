package com.iessanandres.probandootraforma.features.login.presentation

import androidx.lifecycle.ViewModel
import com.iessanandres.probandootraforma.features.login.domain.SaveUsernameUseCase
import com.iessanandres.probandootraforma.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
) : ViewModel() {

    fun validateClicked(userName: String, password: String, isRememberChecked: Boolean): Boolean {
        val isValid = signInUseCase.invoke(userName, password)
        if (isRememberChecked) {
            saveUsernameUseCase(userName)
        }
        return signInUseCase.invoke(userName,password)
    }
}