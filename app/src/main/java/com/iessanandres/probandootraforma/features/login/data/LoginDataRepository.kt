package com.iessanandres.probandootraforma.features.login.data

import com.iessanandres.probandootraforma.features.login.data.local.LoginXmlLocalDataSource
import com.iessanandres.probandootraforma.features.login.data.remote.LoginMockRemoteDataSource
import com.iessanandres.probandootraforma.features.login.domain.LoginRepository

class LoginDataRepository(
    private val localDataSource: LoginXmlLocalDataSource,
    private val remoteDataSource: LoginMockRemoteDataSource
) :
    LoginRepository {

    override fun isValid(userName: String, password: String): Boolean {

        return remoteDataSource.validate(userName, password)

    }

    override fun saveUsername(userName: String) {

        localDataSource.saveUsername(userName)
    }

    override fun deleteUsername() {

        localDataSource.deleteUsername()
    }

    override fun getUsername(): String? {

        return localDataSource.getUsername()
    }

}