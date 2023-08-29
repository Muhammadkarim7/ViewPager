package com.example.viewpager.Adaptar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpager.Models.User
import com.example.viewpager.databinding.Item1Binding

class Adapter(val list: List<User>): PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = Item1Binding.inflate(LayoutInflater.from(container.context), container, false)

        item.img.setImageResource(list[position].img)
        item.txtName.text = list[position].name
        item.txtAbout.text = list[position].about

        container.addView(item.root)
        return item.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}