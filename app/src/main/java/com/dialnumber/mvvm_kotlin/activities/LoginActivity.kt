package com.dialnumber.mvvm_kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.model.login.LoginRequest
import com.dialnumber.mvvm_kotlin.viewmodels.DashboardViewModel
import com.dialnumber.mvvm_kotlin.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etEmail: EditText
    lateinit var etPassword: EditText

    lateinit var btnLogin: Button
    lateinit var tvSignUp: TextView

    lateinit var context: Context

    lateinit var loginViewModel: LoginViewModel

    lateinit var customProgress: RelativeLayout

    lateinit var loginrequest: LoginRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignUp = findViewById(R.id.tvSignUp)

        customProgress = findViewById(R.id.customProgress)

        btnLogin.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)

    }

    fun loginApi() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginrequest = LoginRequest(etEmail.text.toString().trim(), etPassword.text.toString().trim())

        loginViewModel.getLogin(loginrequest)!!.observe(this, Observer { loginResponse ->

            val msg = loginResponse.getToken()
            Log.d("response_set", "" + msg)
            val dashboard = Intent(this, DashboardActivity::class.java)
            startActivity(dashboard)
        })
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnLogin -> {
                loginApi()
            }

            R.id.tvSignUp -> {
                val dashboard = Intent(this, RegisterActivity::class.java)
                startActivity(dashboard)
            }
        }
    }
}
