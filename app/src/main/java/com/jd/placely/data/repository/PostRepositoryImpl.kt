package com.jd.placely.data.repository

import com.jd.placely.R
import com.jd.placely.domain.model.Post
import com.jd.placely.domain.repository.PostRepository
import com.jd.placely.data.network.PostModel
import com.jd.placely.data.network.ApiService

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                val postModels = response.body() ?: emptyList()
                val posts = postModels.map { it.toPost() }
                Result.success(posts)
            } else {
                // Manejar error de la API
                Result.failure(Exception("Error en la respuesta de la API"))
            }
        } catch (e: Exception) {
            // Manejar errores de red u otros errores
            Result.failure(e)
        }
    }

    private fun PostModel.toPost(): Post {
        return Post(
            username = username,
            location = location,
            profileImage = R.drawable.perfil, // Obtén el recurso de imagen adecuado según la URL
            bodyImage = R.drawable.fotopost, // Obtén el recurso de imagen adecuado según la URL
            body = body,
            isLiked = true, // Verifica si el usuario actual está en la lista de likes
            likeCount = likes.size,
            date = date.toString() // Obtén la representación adecuada de la fecha
        )
    }
}
