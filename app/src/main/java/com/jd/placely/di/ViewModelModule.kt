package com.jd.placely.di

import com.jd.placely.data.repository.PostRepository
import com.jd.placely.domain.use_case.GetPostsUseCase
import com.jd.placely.presentation.main_feed.MainFeedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideMainFeedViewModel(
        getPostsUseCase: GetPostsUseCase
    ): MainFeedViewModel {
        return MainFeedViewModel(getPostsUseCase)
    }

    @Provides
    fun provideGetPostsUseCase(repository: PostRepository): GetPostsUseCase {
        return GetPostsUseCase(repository)
    }
}
