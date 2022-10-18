package com.dialnumber.mvvm_kotlin.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dialnumber.mvvm_kotlin.R

class RegisterActivity : AppCompatActivity() {

    lateinit var btnRegister: Button
    lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister = findViewById(R.id.btnRegister)
        tvLogin = findViewById(R.id.tvLogin)
    }
}