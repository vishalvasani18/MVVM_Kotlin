package com.dialnumber.mvvm_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.dialnumber.mvvm_kotlin.R
import com.dialnumber.mvvm_kotlin.model.list_of_users.Datum

class ViewPagerAdapter(private val mContext: Context, private val itemList: MutableList<Datum>) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater!!.inflate(R.layout.item_list_view_pager, container, false)
        var textview: TextView = view.findViewById(R.id.tvProfileName)
        textview.text = itemList[position].getFirstName() + " " + itemList[position].getLastName()
        container.addView(view, 0)
        return view
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}