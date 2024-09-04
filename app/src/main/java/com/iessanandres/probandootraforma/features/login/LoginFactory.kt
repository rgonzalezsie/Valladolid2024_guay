package com.iessanandres.probandootraforma.features.login

import androidx.lifecycle.ViewModel
import com.iessanandres.probandootraforma.features.login.data.LoginDataRepository
import com.iessanandres.probandootraforma.features.login.data.remote.LoginMockRemoteDataSource
import com.iessanandres.probandootraforma.features.login.domain.LoginRepository
import com.iessanandres.probandootraforma.features.login.domain.SignInUseCase
import com.iessanandres.probandootraforma.features.login.presentation.LoginViewModel

class LoginFactory {

    private val loginMockRemoteDataSource: LoginMockRemoteDataSource =
        LoginMockRemoteDataSource()

    private val loginRepository: LoginRepository = provideLoginDataRepository()

    private val signInUseCase: SignInUseCase = provideSignInUseCase()

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)
    }
    // fun provideLoginViewModel() = LoginViewModel() --> Esto es equivalente al anterior


    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginRepository {
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }


}