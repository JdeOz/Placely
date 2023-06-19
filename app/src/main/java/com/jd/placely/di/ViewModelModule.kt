package com.jd.placely.di

import com.jd.placely.domain.repository.LoginRepository
import com.jd.placely.domain.repository.MarkRepository
import com.jd.placely.domain.repository.PostRepository
import com.jd.placely.domain.use_case.GetMarksUseCase
import com.jd.placely.domain.use_case.GetPostsUseCase
import com.jd.placely.domain.use_case.LoginUseCase
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

    //NEW
    @Provides
    fun provideGetMarksUseCase(repository: MarkRepository): GetMarksUseCase {
        return GetMarksUseCase(repository)
    }

    @Provides
    fun provideLoginUseCase(repository: LoginRepository): LoginUseCase {
        return LoginUseCase(repository)
    }
}
