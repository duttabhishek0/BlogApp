package com.abhishek.domain.di

import com.abhishek.domain.repository.GetBlogsRepository
import com.abhishek.domain.use_cases.GetBlogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetBlogUseCases(getBlogsRepository: GetBlogsRepository) : GetBlogsUseCase {
        return GetBlogsUseCase(getBlogsRepository)
    }
}