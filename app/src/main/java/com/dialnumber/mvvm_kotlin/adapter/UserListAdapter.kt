/*
package com.dialnumber.mvvm_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.model.userlist.Datum

class UserListAdapter(
    context: Context,
    userData: List<Datum>
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private var context: Context? = null
    private var userData: ArrayList<Datum>? = ArrayList()

    init {
        this.context = context
        this.userData = ArrayList(userData)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvFirstName: TextView? = null
        var tvLastName: TextView? = null

        init {
            tvFirstName = view.findViewById(R.id.tvFirstName)
            tvLastName = view.findViewById(R.id.tvLastName)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_user_list, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val userList: Datum = userData!!.get(position)

        holder.tvFirstName!!.setText(userList.getFirstName())
        holder.tvLastName!!.setText(userList.getLastName())

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount() = userData!!.size
}*/
