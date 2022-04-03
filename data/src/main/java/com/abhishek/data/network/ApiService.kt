package com.abhishek.data.network

import com.abhishek.data.network.model.BlogsDTO
import retrofit2.http.GET

interface ApiService {

    @GET("post")
    suspend fun getBlogs() : retrofit2.Response<BlogsDTO>
}