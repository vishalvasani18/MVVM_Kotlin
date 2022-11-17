package com.dialnumber.mvvm_kotlin.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.adapter.ListOfUserAdapter
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum
import com.dialnumber.mvvm_kotlin.viewmodels.ListOfUserViewModel
import java.util.ArrayList

class ListOfUserActivity : AppCompatActivity() {

    lateinit var listOfUserViewModel: ListOfUserViewModel
    lateinit var listOfUserAdapter: ListOfUserAdapter
    lateinit var rvUserList: RecyclerView
    private var userList: MutableList<Datum> = ArrayList()

    lateinit var btnViewPager: Button

    lateinit var btnViewPager2:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_user)

        rvUserList = findViewById(R.id.rvUserList)

        btnViewPager = findViewById(R.id.btnViewPager)
        btnViewPager.setOnClickListener(View.OnClickListener {

            val viewpager_activity = Intent(this, ViewPagerActivity::class.java)
            startActivity(viewpager_activity)
        })

        btnViewPager2=findViewById(R.id.btnViewPager2)
        btnViewPager2.setOnClickListener(View.OnClickListener {
            val viewpager2_activity = Intent(this, ViewPager2Activity::class.java)
            startActivity(viewpager2_activity)
        })

        listOfUserViewModel = ViewModelProvider(this).get(ListOfUserViewModel::class.java)

        listOfUserViewModel.getuserlist()!!.observe(this, Observer { userListResponse ->

            if (userListResponse != null) {

                userList = userListResponse.getData() as MutableList<Datum>
                listOfUserAdapter = ListOfUserAdapter(userList)
                val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                rvUserList!!.layoutManager = mLayoutManager
                rvUserList!!.adapter = listOfUserAdapter

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