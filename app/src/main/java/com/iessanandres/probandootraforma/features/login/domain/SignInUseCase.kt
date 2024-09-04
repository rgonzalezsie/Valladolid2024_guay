package com.iessanandres.probandootraforma.features.login.domain

class SignInUseCase(private val loginRepository: LoginRepository) {

    //fun execute () {
    //} Esta y la siguiente son iguales

    operator fun invoke(userName: String, password: String): Boolean {
        // True lo ha hecho perfectamente, False ha fallado
        return loginRepository.isValid(userName, password)

    }
}