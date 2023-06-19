package com.jd.placely.data.datasource

import com.jd.placely.R
import com.jd.placely.domain.model.Mark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalMarkDataSource : MarkDataSource {
    override suspend fun getMarks(): Result<List<Mark>> {

        return withContext(Dispatchers.IO){
            val marks = listOf(
                Mark("lugar1", -16.3897749, -71.550684, R.drawable.perfil),
                Mark("lugar2", -16.389073, -71.5493269, R.drawable.perfil),
                Mark("lugar3", -16.413766684006916, -71.54620725737155, R.drawable.perfil)
                 )

            Result.success(marks)
        }
    }
}