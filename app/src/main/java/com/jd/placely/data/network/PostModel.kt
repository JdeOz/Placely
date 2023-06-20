package com.jd.placely.data.network

data class PostModel(
    val id: String,
    val username: String,
    val user_id: String,
    val location: String,
    val location_id: String,
    val profileImage: String,
    val bodyImage: String,
    val body: String,
    val likes: List<String>,
    val date: DateModel
)

data class DateModel(
    val _seconds: Long,
    val _nanoseconds: Long
)
