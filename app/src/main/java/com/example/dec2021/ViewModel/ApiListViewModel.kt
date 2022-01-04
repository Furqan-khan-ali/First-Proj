package com.example.dec2021.ViewModel

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dec2021.Api
import com.example.dec2021.PostRequestModel
import com.example.dec2021.ResponseModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body

class ApiListViewModel: ViewModel() {

    private val _apiLiveData: MutableLiveData<List<ResponseModel>> = MutableLiveData(listOf())
    val apiLiveData: LiveData<List<ResponseModel>> = _apiLiveData

    val retrofit = Retrofit.Builder()
            .baseUrl("http://jasonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiObj = retrofit.create(Api::class.java)

    fun load(){
        viewModelScope.launch {

            val result = apiObj.getData()
            _apiLiveData.value = result
        }
    }

    fun requestPost(body: String, title: String){
        viewModelScope.launch {
            val objRequest = PostRequestModel(body = body,title = title,userId = "56")
            apiObj.requestPost(objRequest)
        }
    }

}