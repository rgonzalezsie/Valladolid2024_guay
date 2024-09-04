package com.iessanandres.probandootraforma.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.iessanandres.probandootraforma.R
import com.iessanandres.probandootraforma.features.login.LoginFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.action_validate)
        // val indica que es una variable inmutable. Si fuera var será mutable. Lo normal es que sea INMUTABLE
        // R.id.action_validate busca el boton por identificador (id) y que tiene el valor (action_validate)
        actionValidate.setOnClickListener {
            val userName = findViewById<EditText>(R.id.input_username).text.toString()
            val userPassword = findViewById<EditText>(R.id.input_password).text.toString()
            val isValid = loginViewModel.validateClicked(userName, userPassword)
            if (isValid) {
                //Snackbar siempre aparece abajo, pro debajo del teclado
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.message_login_ok,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.message_login_fail,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}