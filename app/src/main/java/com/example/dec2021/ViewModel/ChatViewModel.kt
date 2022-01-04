package com.example.dec2021.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dec2021.Adapters.ChatUIModel

class ChatViewModel: ViewModel() {

    private val _chatLiveData: MutableLiveData<MutableList<ChatUIModel>> = MutableLiveData(
        mutableListOf())
    val chatLiveData: LiveData<MutableList<ChatUIModel>> = _chatLiveData

    fun myChat(text:String){

        val objMyChat = ChatUIModel(myMess = true,text = text,image = null)
        _chatLiveData.value?.add(objMyChat)
    }

    fun otherChat(text:String){

        val objotherChat = ChatUIModel(myMess = false,text = text,image = null)
        _chatLiveData.value?.add(objotherChat)
    }
    
}