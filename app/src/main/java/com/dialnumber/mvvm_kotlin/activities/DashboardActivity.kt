package com.dialnumber.mvvm_kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.viewmodels.DashboardViewModel

class DashboardActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var dashboardViewModel: DashboardViewModel
    lateinit var tvEmail: TextView
    lateinit var btnListOfUsers: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        context = this@DashboardActivity

        tvEmail = findViewById(R.id.tvEmail)
        btnListOfUsers = findViewById(R.id.btnListOfUsers)
        btnListOfUsers.setOnClickListener(View.OnClickListener {
            var userList = Intent(this, ListOfUserActivity::class.java)
            startActivity(userList)
        })

        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        dashboardViewModel.getUser()!!.observe(this, Observer { userResponse ->

            //  wp7progressBar.hideProgressBar()

            val msg = userResponse.getData()?.getEmail()
            Log.d("response_set", "" + msg)

            tvEmail.setText(msg)

            //    lblResponse.text = msg
        })
    }
}
