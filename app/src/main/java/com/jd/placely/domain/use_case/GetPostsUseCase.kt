package com.jd.placely.domain.use_case

import com.jd.placely.domain.repository.PostRepository
import com.jd.placely.domain.model.Post

class GetPostsUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke(): Result<List<Post>> = postRepository.getPosts()
}
