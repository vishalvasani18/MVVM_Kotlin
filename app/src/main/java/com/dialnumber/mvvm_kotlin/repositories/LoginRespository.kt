package com.dialnumber.mvvm_kotlin.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dialnumber.mvvm_kotlin.model.login.LoginRequest
import com.dialnumber.mvvm_kotlin.model.login.LoginResponse
import com.dialnumber.mvvm_kotlin.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRespository {

    val loginData = MutableLiveData<LoginResponse>()

    fun getLoginServiceCall(loginrequest: LoginRequest): MutableLiveData<LoginResponse> {

        val call = RetrofitInstance.apiInterface.login(loginrequest)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                val data = response.body()?.getToken()
                if (data != null) {
                    Log.d("login_user_token", "" + data)
                }
                loginData.value = response.body()
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.d("Error_Msg : ", t.message.toString())
            }

        })

        return loginData
    }
}