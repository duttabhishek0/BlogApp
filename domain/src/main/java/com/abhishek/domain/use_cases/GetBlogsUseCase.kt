package com.abhishek.domain.use_cases

import android.widget.Toast
import com.abhishek.common.Resource
import com.abhishek.domain.model.Blog
import com.abhishek.domain.repository.GetBlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(private val getBlogsRepository: GetBlogsRepository) {

    /**
     * To invoke the Use Cases
     *
     * @return Flow<Resource<List<Blog>>>
     */
    operator fun invoke(): Flow<Resource<List<Blog>>> = flow {
        emit(Resource.Loading(null))
        try {
            val response = getBlogsRepository.getBlogs()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }
}