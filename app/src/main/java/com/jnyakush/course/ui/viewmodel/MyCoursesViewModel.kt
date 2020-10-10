package com.jnyakush.course.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnyakush.course.data.db.entity.MyCourse
import com.jnyakush.course.data.repository.MyCoursesRepository
import com.jnyakush.course.data.retrofit.response.StudentCoursesResponse
import com.jnyakush.course.utils.Resource
import kotlinx.coroutines.launch


class MyCoursesViewModel @ViewModelInject constructor(
    private val repository: MyCoursesRepository
) : ViewModel() {

    private val _myCourseResponse: MutableLiveData<Resource<StudentCoursesResponse>> =
        MutableLiveData()

    val myCourseResponse: LiveData<Resource<StudentCoursesResponse>>
        get() = _myCourseResponse

    /**
     *
     */
    fun myCourses() = viewModelScope.launch {
        _myCourseResponse.value = Resource.Loading
        _myCourseResponse.value = repository.myCourses()
    }

    /**
     *
     */
    fun saveMyCourse(course: MyCourse) = viewModelScope.launch {
        repository.saveMyCourse(course)
    }


    /**
     *
     */
    fun fetchCourses() {
        repository.fetchCourses()
    }
}