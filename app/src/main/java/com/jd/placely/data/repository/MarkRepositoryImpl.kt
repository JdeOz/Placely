package com.jd.placely.data.repository

import com.jd.placely.data.datasource.MarkDataSource
import com.jd.placely.domain.model.Mark
import com.jd.placely.domain.repository.MarkRepository

class MarkRepositoryImpl(
    private val dataSource: MarkDataSource
) : MarkRepository {
    override suspend fun getMarks(): Result<List<Mark>> {
        return dataSource.getMarks()
    }
}