package com.iessanandres.probandootraforma.features.login.domain

interface LoginRepository {

    fun isValid(userName: String, password: String): Boolean

    fun saveUsername(userName: String)

}