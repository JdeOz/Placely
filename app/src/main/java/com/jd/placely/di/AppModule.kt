package com.jd.placely.di

import com.jd.placely.data.datasource.LocalPostDataSource
import com.jd.placely.data.datasource.PostDataSource
import com.jd.placely.data.repository.PostRepository
import com.jd.placely.data.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePostRepository(dataSource: PostDataSource): PostRepository {
        return PostRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun providePostDataSource(): PostDataSource {
        return LocalPostDataSource()
    }

}