package com.jd.placely.presentation.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jd.placely.domain.model.Mark
import com.jd.placely.domain.model.Post
import com.jd.placely.domain.use_case.GetMarksUseCase
import com.jd.placely.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val getMarksUseCase: GetMarksUseCase
) : ViewModel() {
    private val _marks = MutableLiveData<List<Mark>>()
    val marks: LiveData<List<Mark>> = _marks

    init {
        loadMarks()
    }

    private fun loadMarks() {
        viewModelScope.launch {
            val result = getMarksUseCase()
            if (result.isSuccess) {
                _marks.value = result.getOrNull()
            } else {
                // Handle error
            }
        }
    }
}