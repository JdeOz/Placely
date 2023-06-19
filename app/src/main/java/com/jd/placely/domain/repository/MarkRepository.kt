package com.jd.placely.domain.repository

import com.jd.placely.domain.model.Mark

interface MarkRepository {
    suspend fun getMarks(): Result<List<Mark>>
}