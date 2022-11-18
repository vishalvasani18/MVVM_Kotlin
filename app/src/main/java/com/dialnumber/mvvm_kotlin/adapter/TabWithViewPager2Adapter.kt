package com.dialnumber.mvvm_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum

class TabWithViewPager2Adapter(private val data: MutableList<Datum>) :
    RecyclerView.Adapter<TabWithViewPager2Adapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_tab_with_view_pager_two, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvId: TextView = itemView.findViewById(R.id.tvId)
        private val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)


        fun bind(data: Datum) {
            tvId.text = data.getFirstName() + " " + data.getLastName()
            tvEmail.text = data.getEmail()
            tvName.text = data.getFirstName() + " " + data.getLastName()
        }
    }
}