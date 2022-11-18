package com.dialnumber.mvvm_kotlin.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.adapter.TabWithViewPager2Adapter
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum
import com.dialnumber.mvvm_kotlin.viewmodels.ListOfUserViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabWithViewPager2Activity : AppCompatActivity() {

    lateinit var tlUsers: TabLayout
    lateinit var vpUsers: ViewPager2
    lateinit var tabWithViewPager2Adapter: TabWithViewPager2Adapter
    private var userList: MutableList<Datum> = ArrayList()
    lateinit var listOfUserViewModel: ListOfUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_with_viewpager_two)

        tlUsers = findViewById(R.id.tlUsers)

        vpUsers = findViewById(R.id.vpUsers)
        listOfUserViewModel = ViewModelProvider(this).get(ListOfUserViewModel::class.java)

        listOfUserViewModel.getuserlist()!!.observe(this, Observer { userListResponse ->

            if (userListResponse != null) {

                userList = userListResponse.getData() as MutableList<Datum>
                for (idx in 0 until userList.size) {
                    tlUsers.addTab(
                        tlUsers.newTab().setText(userList.get(idx).getFirstName().toString())
                    )
                }
                tabWithViewPager2Adapter = TabWithViewPager2Adapter(userList)
                vpUsers.adapter = tabWithViewPager2Adapter
                vpUsers.orientation = ViewPager2.ORIENTATION_HORIZONTAL

                TabLayoutMediator(tlUsers, vpUsers) { tab, position ->
                    tab.text = userList[position].toString()
                }.attach()

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