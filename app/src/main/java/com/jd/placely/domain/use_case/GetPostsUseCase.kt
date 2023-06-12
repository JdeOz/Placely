package com.jd.placely.domain.use_case

import com.jd.placely.data.repository.PostRepository
import com.jd.placely.domain.model.Post

class GetPostsUseCase(private val postRepository: PostRepository) {
    suspend fun getPosts(): Result<List<Post>> {
        return postRepository.getPosts()
    }
}
