package com.dialnumber.mvvm_kotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dialnumber.mvvm_kotlin.model.user_detail.UserResponse
import com.dialnumber.mvvm_kotlin.repositories.DashboardRespository

class DashboardViewModel : ViewModel() {

    var userLiveData: MutableLiveData<UserResponse>? = null

    fun getUser(): LiveData<UserResponse>? {
        userLiveData = DashboardRespository.getServicesApiCall()
        return userLiveData
    }

}