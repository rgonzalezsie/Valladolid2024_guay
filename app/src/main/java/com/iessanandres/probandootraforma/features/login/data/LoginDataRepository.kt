package com.iessanandres.probandootraforma.features.login.data

import com.iessanandres.probandootraforma.features.login.data.remote.LoginMockRemoteDataSource
import com.iessanandres.probandootraforma.features.login.domain.LoginRepository

class LoginDataRepository(private val remoteDataSource: LoginMockRemoteDataSource) :
    LoginRepository {
    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName, password)

    }

}