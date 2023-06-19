package com.jd.placely.domain.use_case

import com.jd.placely.domain.model.Mark
import com.jd.placely.domain.repository.MarkRepository

class GetMarksUseCase(private val markRepository: MarkRepository) {
    suspend operator fun invoke(): Result<List<Mark>> = markRepository.getMarks()
}