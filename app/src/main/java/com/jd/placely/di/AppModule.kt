package com.jd.placely.di

import com.jd.placely.data.datasource.LocalMarkDataSource
import com.jd.placely.data.datasource.LocalPostDataSource
import com.jd.placely.data.datasource.MarkDataSource
import com.jd.placely.data.datasource.PostDataSource
import com.jd.placely.data.repository.FirebaseLoginRepository
import com.jd.placely.data.repository.MarkRepositoryImpl
import com.jd.placely.domain.repository.PostRepository
import com.jd.placely.data.repository.PostRepositoryImpl
import com.jd.placely.domain.repository.LoginRepository
import com.jd.placely.domain.repository.MarkRepository
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
//NEW
    @Provides
    @Singleton
    fun provideMarkRepository(dataSource: MarkDataSource): MarkRepository {
        return MarkRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(): LoginRepository {
        return FirebaseLoginRepository()
    }

    @Provides
    @Singleton
    fun providePostDataSource(): PostDataSource {
        return LocalPostDataSource()
    }
    //new
    @Provides
    @Singleton
    fun provideMarkDataSource(): MarkDataSource {
        return LocalMarkDataSource()
    }

}