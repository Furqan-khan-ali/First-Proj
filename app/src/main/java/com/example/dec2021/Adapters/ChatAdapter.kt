package com.example.dec2021.Adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.dec2021.databinding.ItemMychatBinding
import com.example.dec2021.databinding.ItemOtherchatBinding

class ChatAdapter(private val itemClickListner: (reponse : ChatUIModel) -> Unit): RecyclerView.Adapter<ChatViewHolder>() {

    var chatList: MutableList<ChatUIModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        if (viewType == 0 ) {
            val myChatViewHolder = MyChatViewHolder(
                binding = ItemMychatBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
            return myChatViewHolder
        }else{
            val otherChatViewHolder = OtherChatViewHolder(
                binding = ItemOtherchatBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
            return otherChatViewHolder
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(viewHolder: ChatViewHolder, position: Int) {
        if(viewHolder is MyChatViewHolder){
            viewHolder.binding.textMy.text = chatList[position].text
            viewHolder.binding.root.setOnClickListener {
                itemClickListner.invoke(chatList[position])
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
        if (chatList[position].myMess == true){
            return 0
        }else{
            return 1
        }
    }

    fun submitList(list: MutableList<ChatUIModel>){
        chatList = list
    }

}

open class ChatViewHolder(item: View) : RecyclerView.ViewHolder(item)

class OtherChatViewHolder(val binding: ItemOtherchatBinding) : ChatViewHolder(binding.root){

}

class MyChatViewHolder(val binding: ItemMychatBinding): ChatViewHolder(binding.root){

}

data class ChatUIModel(
    val text : String,
    val myMess : Boolean,
    val image : Bitmap?
)