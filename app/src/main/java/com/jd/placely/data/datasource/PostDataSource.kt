package com.jd.placely.data.datasource

import com.jd.placely.domain.model.Post

interface PostDataSource {
    suspend fun getPosts(): Result<List<Post>>
}