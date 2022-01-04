package com.example.dec2021.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dec2021.databinding.ItemViewpagerBinding

class ViewPagerAdapter: RecyclerView.Adapter<ViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val viewHolder = ViewPagerViewHolder(binding = ItemViewpagerBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))
        return viewHolder
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class ViewPagerViewHolder(val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root)