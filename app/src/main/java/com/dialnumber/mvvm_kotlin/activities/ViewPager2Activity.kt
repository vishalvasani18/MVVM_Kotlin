package com.dialnumber.mvvm_kotlin.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.adapter.ViewPager2Adapter
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum
import com.dialnumber.mvvm_kotlin.viewmodels.ListOfUserViewModel

class ViewPager2Activity : AppCompatActivity() {

    lateinit var listOfUserViewModel: ListOfUserViewModel
    lateinit var viewPager2Adapter: ViewPager2Adapter
    lateinit var vpAllUsers: ViewPager2
    private var userList: MutableList<Datum> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_two)

        vpAllUsers=findViewById(R.id.vpAllUsers)
        listOfUserViewModel = ViewModelProvider(this).get(ListOfUserViewModel::class.java)

        listOfUserViewModel.getuserlist()!!.observe(this, Observer { userListResponse ->

            if (userListResponse != null) {

                userList = userListResponse.getData() as MutableList<Datum>
                viewPager2Adapter = ViewPager2Adapter(userList)
                vpAllUsers.adapter = viewPager2Adapter
                vpAllUsers.orientation = ViewPager2.ORIENTATION_VERTICAL

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