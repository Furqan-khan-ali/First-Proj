package com.example.dec2021

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("posts")
    suspend fun getData() : List<ResponseModel>

    @POST("posts")
    suspend fun requestPost(@Body request: PostRequestModel) : PostRequestModel
}

data class ResponseModel(
    val body : String,
    val title: String,
    val id: Int,
    val userId: String
)

data class PostRequestModel(
        val body : String,
        val title: String,
        val userId: String
)