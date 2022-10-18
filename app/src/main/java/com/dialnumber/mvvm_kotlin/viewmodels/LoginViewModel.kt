package com.dialnumber.mvvm_kotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dialnumber.mvvm_kotlin.model.login.LoginRequest
import com.dialnumber.mvvm_kotlin.model.login.LoginResponse
import com.dialnumber.mvvm_kotlin.repositories.LoginRespository

class LoginViewModel :ViewModel() {
    var loginLiveData: MutableLiveData<LoginResponse>? = null

    fun getLogin(loginrequest:LoginRequest): LiveData<LoginResponse>? {
        loginLiveData = LoginRespository.getLoginServiceCall(loginrequest)
        return loginLiveData
    }
}