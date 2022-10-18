package com.dialnumber.mvvm_kotlin.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dialnumber.mvvm_kotlin.model.user_detail.UserResponse
import com.dialnumber.mvvm_kotlin.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DashboardRespository {

    val userData = MutableLiveData<UserResponse>()

    fun getServicesApiCall(): MutableLiveData<UserResponse> {

        val call = RetrofitInstance.apiInterface.getServices()

        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                val data = response.body()
                if (data != null) {
                    Log.d("user_email", "" + data.getData()!!.getEmail())
                }
                userData.value = response.body()
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.d("Error_Msg : ", t.message.toString())
            }

        })

        return userData
    }

}