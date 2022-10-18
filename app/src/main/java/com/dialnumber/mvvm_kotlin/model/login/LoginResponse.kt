package com.dialnumber.mvvm_kotlin.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("token")
    @Expose
    private var token: String? = null

    fun getToken(): String? {
        return token
    }

    fun setToken(token: String?) {
        this.token = token
    }
}