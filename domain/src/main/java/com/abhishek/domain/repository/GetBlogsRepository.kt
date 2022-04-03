package com.abhishek.domain.repository

import com.abhishek.domain.model.Blog
import retrofit2.Response

interface GetBlogsRepository {
    suspend fun getBlogs() : List<Blog>
}