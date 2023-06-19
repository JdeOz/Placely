package com.jd.placely.data.datasource

import com.jd.placely.R
import com.jd.placely.domain.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalPostDataSource : PostDataSource {
    override suspend fun getPosts(): Result<List<Post>> {

        return withContext(Dispatchers.IO){
            val posts = listOf(
                Post("usuario1", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 10,"Hace 12 minutos"),
                Post("usuario2", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", true, 15, "Hace 32 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 43 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 43 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 8 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", true, 20, "Hace 3 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 33 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 54 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 1 minutos"),
                Post("usuario3", "San Francisco, CA", R.drawable.perfil, R.drawable.fotopost,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas finibus ligula in tellus viverra.", false, 20,"Hace 2 minutos")
            )

            Result.success(posts)
        }
    }
}