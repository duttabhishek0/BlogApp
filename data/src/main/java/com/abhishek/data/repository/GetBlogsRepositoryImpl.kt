package com.abhishek.data.repository

import com.abhishek.data.mapper.toDomain
import com.abhishek.data.network.ApiService
import com.abhishek.data.network.utils.SafeApiRequest
import com.abhishek.domain.model.Blog
import com.abhishek.domain.repository.GetBlogsRepository
import javax.inject.Inject


class GetBlogsRepositoryImpl @Inject constructor(private val apiService: ApiService) : GetBlogsRepository, SafeApiRequest() {
    override suspend fun getBlogs(): List<Blog> {
        val response = safeApiRequest {apiService.getBlogs()}
        return response.data?.toDomain()?: emptyList()
    }


}