package com.iessanandres.probandootraforma.features.login.domain

class DeleteUsernameUseCase (private val loginRepository: LoginRepository) {
    operator fun invoke () {
        loginRepository.deleteUsername()
    }
}