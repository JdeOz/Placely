package com.jd.placely.data.datasource

import com.jd.placely.domain.model.Mark

interface MarkDataSource {
    suspend fun getMarks(): Result<List<Mark>>
}