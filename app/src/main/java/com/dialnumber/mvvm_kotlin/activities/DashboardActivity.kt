package com.dialnumber.mvvm_kotlin.activities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.siesta.session.SessionManager
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.viewmodels.DashboardViewModel

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var context: Context

    lateinit var dashboardViewModel: DashboardViewModel
    lateinit var tvEmail: TextView
    lateinit var btnListOfUsers: Button
    lateinit var btnLogout: Button

    private lateinit var session: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        context = this@DashboardActivity
        session = SessionManager(this)


        tvEmail = findViewById(R.id.tvEmail)
        btnListOfUsers = findViewById(R.id.btnListOfUsers)
        btnListOfUsers.setOnClickListener(this)

        btnLogout = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener(this)


        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        dashboardViewModel.getUser()!!.observe(this, Observer { userResponse ->

            //  wp7progressBar.hideProgressBar()

            val msg = userResponse.getData()?.getEmail()
            Log.d("response_set", "" + msg)

            tvEmail.setText(msg)

            //    lblResponse.text = msg
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.btnListOfUsers -> {
                var userList = Intent(this, ListOfUserActivity::class.java)
                startActivity(userList)
            }

            R.id.btnLogout -> {
                logoutprompt()
            }
        }
    }

    private fun logoutprompt() {
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("MVVM_KOTLIN_DEMO")
        alertDialogBuilder.setMessage("Are you sure want to logout...? ")
        alertDialogBuilder.setPositiveButton("yes",
            DialogInterface.OnClickListener { arg0, arg1 ->
                session.clear()
                val login_redirect = Intent(context, LoginActivity::class.java)
                startActivity(login_redirect)
            })
        alertDialogBuilder.setNegativeButton("No",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
