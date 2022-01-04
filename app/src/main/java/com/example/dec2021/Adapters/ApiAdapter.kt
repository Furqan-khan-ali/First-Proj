package com.example.dec2021.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dec2021.ResponseModel
import com.example.dec2021.databinding.ItemApiBinding

class ApiAdapter: RecyclerView.Adapter<ApiViewHolder>() {

    var apiList: List<ResponseModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val viewHolder = ApiViewHolder(binding = ItemApiBinding.inflate(LayoutInflater.from(parent.context),
        parent,false))
        return viewHolder
    }

    override fun getItemCount(): Int {
        return  apiList.size
    }

    override fun onBindViewHolder(viewHolder: ApiViewHolder, position: Int) {
       viewHolder.binding.textBody.text = apiList[position].body
       viewHolder.binding.textTitle.text = apiList[position].title
    }

    fun submitList(list: List<ResponseModel>){
        apiList = list
    }

}

class ApiViewHolder(val binding: ItemApiBinding): RecyclerView.ViewHolder(binding.root)

