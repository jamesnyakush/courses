package com.jnyakush.course.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnyakush.course.data.repository.CourseRepository
import com.jnyakush.course.data.retrofit.response.CoursesResponse
import com.jnyakush.course.utils.Resource
import kotlinx.coroutines.launch


class CourseViewModel @ViewModelInject constructor(
    private val repository: CourseRepository
) : ViewModel() {

    private val _courseResponse: MutableLiveData<Resource<CoursesResponse>> = MutableLiveData()

    val courseResponse: LiveData<Resource<CoursesResponse>>
        get() = _courseResponse


    fun addCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) {
        //repository.postCourse(courseCode, courseName, description, instructor)
    }

    fun fetchCourses() = viewModelScope.launch {
        _courseResponse.value = Resource.Loading
        _courseResponse.value = repository.getCourse()
    }
}