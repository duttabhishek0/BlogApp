package com.abhishek.data.network

import com.abhishek.common.Constants
import com.abhishek.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("post")
    suspend fun getBlogs(
        @Header("app-id") appId:String= Constants.APP_ID
    ) : Response<BlogsDTO>
}