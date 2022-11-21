package com.dialnumber.mvvm_kotlin.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.adapter.Viewpager2WithDothIndicatorAdapter
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum
import com.dialnumber.mvvm_kotlin.viewmodels.ListOfUserViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class ViewPager2WithDotIndicatorActivity : AppCompatActivity() {

    lateinit var dotindicator: TabLayout
    lateinit var vpUsers: ViewPager2
    lateinit var viewpager2WithDothIndicatorAdapter: Viewpager2WithDothIndicatorAdapter
    private var userList: MutableList<Datum> = ArrayList()
    lateinit var listOfUserViewModel: ListOfUserViewModel

    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2_with_dot_indicator)

        vpUsers = findViewById(R.id.vpUsers)
        dotindicator = findViewById(R.id.dotindicator)

        listOfUserViewModel = ViewModelProvider(this).get(ListOfUserViewModel::class.java)

        listOfUserViewModel.getuserlist()!!.observe(this, Observer { userListResponse ->

            if (userListResponse != null) {

                userList = userListResponse.getData() as MutableList<Datum>
                viewpager2WithDothIndicatorAdapter = Viewpager2WithDothIndicatorAdapter(userList)
                vpUsers.adapter = viewpager2WithDothIndicatorAdapter
                vpUsers.orientation = ViewPager2.ORIENTATION_HORIZONTAL

                TabLayoutMediator(dotindicator, vpUsers) { tab, position -> }.attach()

                val handler = Handler()
                var page: Int? = 0
                val Update = Runnable {
                    val numPages: Int = userList.size
                    page = (page?.plus(1))?.rem(numPages)
                    vpUsers!!.setCurrentItem(page!!, true)
                }

                val timer = Timer()
                timer!!.schedule(object : TimerTask() {
                    // task to be scheduled
                    override fun run() {
                        handler.post(Update)
                    }
                }, 3000, 3000)


            } else {
                Toast.makeText(
                    this,
                    getString(R.string.unable_to_connect_server),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}