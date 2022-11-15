package com.dialnumber.mvvm_kotlin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.app.siesta.session.SessionManager
import com.dialnumber.mvvm_kotlin.R

class SplashActivity : AppCompatActivity() {

    lateinit var session: SessionManager
    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        session = SessionManager(this)

        Handler().postDelayed(
            {
                if (session.getBooleanValue(SessionManager.IS_LOGGED_IN)!!) {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)

                } else {
                    val intent1 = Intent(this, LoginActivity::class.java)
                    startActivity(intent1)
                    finish()
                }

            }, SPLASH_TIME_OUT
        )
    }
}