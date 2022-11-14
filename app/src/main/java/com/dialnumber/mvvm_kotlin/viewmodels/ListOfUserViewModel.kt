package com.dialnumber.mvvm_kotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dialnumber.mvvm_kotlin.model.list_of_users.ListOfUserResponse
import com.dialnumber.mvvm_kotlin.repositories.ListOfUserRepository

class ListOfUserViewModel : ViewModel() {
     lateinit var listUserData: MutableLiveData<ListOfUserResponse>

    fun getuserlist(): LiveData<ListOfUserResponse> {
        listUserData = ListOfUserRepository().getUserListApiCall()
        return listUserData
    }
}