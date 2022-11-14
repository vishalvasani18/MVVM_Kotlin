package com.dialnumber.mvvm_kotlin.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dialnumber.mvvm_kotlin.model.list_of_users.ListOfUserResponse
import com.dialnumber.mvvm_kotlin.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListOfUserRepository {
    val userlistLiveData = MutableLiveData<ListOfUserResponse>()

    fun getUserListApiCall(): MutableLiveData<ListOfUserResponse> {
        val call =RetrofitInstance.apiInterface.getUserList()
        if (call != null) {
            call.enqueue(object : Callback<ListOfUserResponse> {
                override fun onResponse(call: Call<ListOfUserResponse>, response: Response<ListOfUserResponse>) {
                    if (response.body() != null) {
                        userlistLiveData.setValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ListOfUserResponse>, t: Throwable) {
                    Log.d("API_error_msg","Something went wrong")
                }
            })
        }
        return userlistLiveData
    }
}
