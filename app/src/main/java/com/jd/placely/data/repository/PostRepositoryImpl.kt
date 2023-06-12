package com.jd.placely.data.repository

import com.jd.placely.data.datasource.PostDataSource
import com.jd.placely.domain.model.Post

class PostRepositoryImpl(
    private val dataSource: PostDataSource
) : PostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        return dataSource.getPosts()
    }
}