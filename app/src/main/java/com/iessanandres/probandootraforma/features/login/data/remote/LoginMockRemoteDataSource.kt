package com.iessanandres.probandootraforma.features.login.data.remote

class LoginMockRemoteDataSource {
    private val username = "android"
    private val password = "1234"

    fun validate(userName: String, password: String): Boolean {
        return ((this.username == userName) && (this.password == password))
    }
}