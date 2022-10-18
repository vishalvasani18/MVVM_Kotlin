package com.dialnumber.mvvm_kotlin.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
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

    /*  private var dashboardViewModel: DashboardViewModel? = null
      var userListAdapter: UserListAdapter? = null
      lateinit var rvUserList: RecyclerView
      var userList: ArrayList<Datum>? = ArrayList()
      var page = 1

      companion object {
          var dashboardActivity: Activity? = null
      }

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_dashboard)

          dashboardActivity = this@DashboardActivity

          dashboardViewModel = ViewModelProviders.of(this@DashboardActivity).get(DashboardViewModel::class.java)

          rvUserList = findViewById(R.id.rvUserList)

          callgetListApi()

      }

      override fun onCreateOptionsMenu(menu: Menu): Boolean {
          // Inflate the menu; this adds items to the action bar if it is present.
          menuInflater.inflate(R.menu.menu_main, menu)
          return true
      }

      override fun onOptionsItemSelected(item: MenuItem): Boolean {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          return when (item.itemId) {
              R.id.action_settings -> true
              else -> super.onOptionsItemSelected(item)
          }
      }

      private fun callgetListApi() {
          if (dashboardViewModel != null) {
              ProgressUtils.ShowProgressDialog(this@DashboardActivity)

              *//*  val queryParams = LinkedHashMap<String, String>()
              queryParams["EmpCd"] = AppPreferences.empCd
              queryParams["TrnId"] = trnId.toString()
              queryParams["AppToken"] = AppUtils.getMacAddr()
              queryParams["ProId"] = proId
  *//*

            val queryParams = LinkedHashMap<String, String>()
            queryParams["page"] = page.toString()

            dashboardViewModel!!.getuserlist(queryParams)
                .observe(this) { dataModel ->
                    ProgressUtils.DismissProgressDialog(this@DashboardActivity)
                    if (dataModel != null) {
                        Toast.makeText(
                            this@DashboardActivity,
                            "dashboardViewModel",
                            Toast.LENGTH_LONG
                        ).show()
                        userList?.let { setUserData(it) }
                    } else {

                    }
                }
        }
    }

    private fun setUserData(userList: ArrayList<Datum>) {
        userListAdapter = UserListAdapter(this, userList)
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvUserList.layoutManager = manager
        rvUserList.adapter = userListAdapter
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        context = this@DashboardActivity

        tvEmail = findViewById(R.id.tvEmail)

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
