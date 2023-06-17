package com.jd.placely.domain.repository

import com.jd.placely.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
}