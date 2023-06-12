package com.jd.placely.domain.model

data class Post(
    val username: String,
    val location: String,
    val profileImage: Int,
    val bodyImage: Int,
    val body: String,
    val isLiked: Boolean,
    val likeCount: Int,
    val date: String
)