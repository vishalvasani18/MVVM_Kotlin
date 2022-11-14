package com.dialnumber.mvvm_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum

class ListOfUserAdapter(private val userList: List<Datum>) :
    RecyclerView.Adapter<ListOfUserAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var tvProfileName: TextView

        init {
            tvProfileName = view.findViewById(R.id.tvProfileName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_view_pager, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val model = userList?.get(position)
        if (model != null) {
            holder.tvProfileName.setText(model.getFirstName() + " " + model.getLastName())
        }
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }
}