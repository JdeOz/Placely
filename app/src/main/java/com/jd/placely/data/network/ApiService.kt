package com.jd.placely.data.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/posts")
    suspend fun getPosts(): Response<List<PostModel>>
}