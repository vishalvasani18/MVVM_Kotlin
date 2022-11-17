package com.dialnumber.mvvm_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum

class ViewPager2Adapter(private val data:MutableList<Datum>) : RecyclerView.Adapter<ViewPager2Adapter.PagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_view_pager_two_list, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tvName)

        fun bind(data: Datum){
            tvName.text = data.getFirstName()+" "+data.getLastName()
        }
    }
}