package com.dialnumber.mvvm_kotlin.network

import com.dialnumber.mvvm_kotlin.model.list_of_users.ListOfUserResponse
import com.dialnumber.mvvm_kotlin.model.login.LoginRequest
import com.dialnumber.mvvm_kotlin.model.login.LoginResponse
import com.dialnumber.mvvm_kotlin.model.user_detail.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    fun login(@Body loginrequest: LoginRequest): Call<LoginResponse>

    @GET("users/2")
    fun getServices(): Call<UserResponse>

    @GET("users?page=2")
    fun getUserList():Call<ListOfUserResponse>

}