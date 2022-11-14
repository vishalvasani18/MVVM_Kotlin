package com.dialnumber.mvvm_kotlin.model.list_of_users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("first_name")
    @Expose
    private var firstName: String? = null

    @SerializedName("last_name")
    @Expose
    private var lastName: String? = null

    @SerializedName("avatar")
    @Expose
    private var avatar: String? = null

    constructor(id: Int?, email: String?, firstName: String?, lastName: String?, avatar: String?) {
        this.id = id
        this.email = email
        this.firstName = firstName
        this.lastName = lastName
        this.avatar = avatar
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getFirstName(): String? {
        return firstName
    }

    fun setFirstName(firstName: String?) {
        this.firstName = firstName
    }

    fun getLastName(): String? {
        return lastName
    }

    fun setLastName(lastName: String?) {
        this.lastName = lastName
    }

    fun getAvatar(): String? {
        return avatar
    }

    fun setAvatar(avatar: String?) {
        this.avatar = avatar
    }

}