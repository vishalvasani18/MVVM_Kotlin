package com.dialnumber.mvvm_kotlin.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.adapter.ViewPagerAdapter
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum
import com.dialnumber.mvvm_kotlin.viewmodels.ListOfUserViewModel

class ViewPagerActivity : AppCompatActivity() {

    lateinit var listOfUserViewModel: ListOfUserViewModel
    lateinit var listOfUserAdapter: ViewPagerAdapter
    lateinit var vpUsers: ViewPager
    private var userList: MutableList<Datum> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        vpUsers = findViewById(R.id.vpUsers)
        listOfUserViewModel = ViewModelProvider(this).get(ListOfUserViewModel::class.java)

        listOfUserViewModel.getuserlist()!!.observe(this, Observer { userListResponse ->

            if (userListResponse != null) {

             /*   for (data in userList)
                {
                    userList.add(Datum(data.getId(), data.getEmail(), data.getFirstName(), data.getLastName(), data.getAvatar()))
                }
*/
                userList = userListResponse.getData() as MutableList<Datum>
                listOfUserAdapter = ViewPagerAdapter(this, userList)
                vpUsers.adapter = listOfUserAdapter

                /* userList = userListResponse.getData() as MutableList<Datum>
                 listOfUserAdapter = ListOfUserAdapter(userList)
                 val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                 rvUserList!!.layoutManager = mLayoutManager
                 rvUserList!!.adapter = listOfUserAdapter*/

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
