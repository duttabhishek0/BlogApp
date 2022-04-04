package com.abhishek.data.network.di

import com.abhishek.common.Constants
import com.abhishek.data.network.ApiService
import com.abhishek.data.repository.GetBlogsRepositoryImpl
import com.abhishek.domain.repository.GetBlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}