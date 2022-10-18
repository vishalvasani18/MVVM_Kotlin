package com.dialnumber.mvvm_kotlin.model.user_detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class UserResponse {

    @SerializedName("data")
    @Expose
    private var data: Data? = null

    @SerializedName("support")
    @Expose
    private var support: Support? = null

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }

    fun getSupport(): Support? {
        return support
    }

    fun setSupport(support: Support?) {
        this.support = support
    }
}