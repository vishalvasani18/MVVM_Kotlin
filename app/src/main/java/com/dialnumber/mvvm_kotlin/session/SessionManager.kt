package com.app.siesta.session

import android.content.Context
import android.content.SharedPreferences


class SessionManager {

    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var ctx: Context
    var PRIVATE_MODE: Int = 0
    var SIESTA: String = "SIESTA"

    constructor(ctx: Context?) {
        this.ctx = ctx!!
        pref = ctx.getSharedPreferences(SIESTA, PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        val USER_TOKEN: String = "USER_TOKEN"
        val IS_LOGGED_IN: String = "IS_LOGGED_IN"
    }

    fun clear() {
        editor.clear()
        editor.commit()
    }

    fun setValue(key: String, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getValue(key: String?): String? {

        if (this.pref.contains(key) != null) {
            return this.pref.getString(key, "")
        }
        return "";
    }

    fun setBooleanValue(key: String, value: Boolean?) {
        if (value != null) {
            editor.putBoolean(key, value)
        }
        editor.commit()
    }

    fun getBooleanValue(key: String?): Boolean? {
        if (this.pref.contains(key) != null) {
            return this.pref.getBoolean(key, false)
        }
        return false;
    }

}