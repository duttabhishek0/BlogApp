package com.abhishek.data.network.di

import android.content.Context
import com.abhishek.common.Constants
import com.abhishek.data.network.ApiService
import com.abhishek.data.repository.GetBlogsRepositoryImpl
import com.abhishek.data.room.BlogDAO
import com.abhishek.data.room.BlogDataBase
import com.abhishek.domain.repository.GetBlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofitObject : Retrofit) : ApiService {
        return retrofitObject.create(ApiService::class.java)
    }

    @Provides
    fun provideGetBlogsRepository(apiService : ApiService) : GetBlogsRepository {
        return GetBlogsRepositoryImpl(apiService = apiService)
    }

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): BlogDataBase {
        return BlogDataBase.getInstance(context)
    }

    @Provides
    fun provideDAO(blogDataBase: BlogDataBase): BlogDAO {
        return blogDataBase.getBlogDAO()
    }
}