package com.dialnumber.mvvm_kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.helpers.NetworkUtils
import com.dialnumber.mvvm_kotlin.model.login.LoginRequest
import com.dialnumber.mvvm_kotlin.viewmodels.LoginViewModel
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etEmail: EditText
    lateinit var etPassword: EditText

    lateinit var btnLogin: Button
    lateinit var tvSignUp: TextView

    lateinit var context: Context

    lateinit var loginViewModel: LoginViewModel

    lateinit var customProgress: RelativeLayout

    lateinit var loginrequest: LoginRequest

    lateinit var ivFBLogin: ImageView

    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignUp = findViewById(R.id.tvSignUp)
        ivFBLogin = findViewById(R.id.ivFBLogin)

        customProgress = findViewById(R.id.customProgress)

        btnLogin.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
        ivFBLogin.setOnClickListener(this)
    }

    fun loginApi() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginrequest = LoginRequest(etEmail.text.toString().trim(), etPassword.text.toString().trim())

        customProgress.visibility = View.VISIBLE

        loginViewModel.getLogin(loginrequest)!!.observe(this, Observer { loginResponse ->

            customProgress.visibility = View.GONE
            if (loginResponse != null) {

                val msg = loginResponse.getToken()
                Log.d("response_set", "" + msg)
                val dashboard = Intent(this, DashboardActivity::class.java)
                startActivity(dashboard)

            } else {
                customProgress.visibility = View.GONE
                Toast.makeText(
                    this@LoginActivity,
                    getString(R.string.unable_to_connect_server),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnLogin -> {

                if (NetworkUtils.isNetworkAvailable(this@LoginActivity)) {
                    loginApi()

                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.no_internet_description),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            R.id.tvSignUp -> {
                val dashboard = Intent(this, RegisterActivity::class.java)
                startActivity(dashboard)
            }

            R.id.ivFBLogin -> {
                fblogin()
            }
        }
    }

    fun fblogin() {
        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance()
            .logInWithReadPermissions(this, Arrays.asList("public_profile", "email"))
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

                override fun onSuccess(result: LoginResult) {
                    TODO("Not yet implemented")
                    Log.d("MainActivity", "Facebook token: " + result.accessToken.token)

                }

                override fun onCancel() {
                    TODO("Not yet implemented")
                    Log.d("MainActivity", "Facebook onCancel.")
                }

                override fun onError(error: FacebookException) {
                    TODO("Not yet implemented")
                    Log.d("MainActivity", "Facebook onError.")
                }

            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}
