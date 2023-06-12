package com.jd.placely.data.repository

import com.jd.placely.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
}