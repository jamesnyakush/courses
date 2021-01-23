package com.jnyakush.course.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnyakush.course.data.db.entity.Course
import com.jnyakush.course.data.repository.CourseRepository
import com.jnyakush.course.data.retrofit.response.CourseResponse
import com.jnyakush.course.data.retrofit.response.CoursesResponse
import com.jnyakush.course.data.retrofit.response.RegCourseResponse
import com.jnyakush.course.utils.Resource
import kotlinx.coroutines.launch


class CourseViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    private val _coursesResponse: MutableLiveData<Resource<CoursesResponse>> = MutableLiveData()

    val coursesResponse: LiveData<Resource<CoursesResponse>>
        get() = _coursesResponse

    private val _courseResponse: MutableLiveData<Resource<CourseResponse>> = MutableLiveData()

    val courseResponse: LiveData<Resource<CourseResponse>>
        get() = _courseResponse

    private val _regCourseResponse: MutableLiveData<Resource<RegCourseResponse>> = MutableLiveData()

    val regCourseResponse: LiveData<Resource<RegCourseResponse>>
        get() = _regCourseResponse



    fun addCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) = viewModelScope.launch {
        _courseResponse.value = Resource.Loading
        _courseResponse.value =
            repository.postCourse(courseCode, courseName, description, instructor)
    }



    fun fetchCourses() = viewModelScope.launch {
        _coursesResponse.value = Resource.Loading
        _coursesResponse.value = repository.getCourse()
    }

    fun registerCourse(
        courseId: String
    ) = viewModelScope.launch {
        _regCourseResponse.value = Resource.Loading
        _regCourseResponse.value = repository.registerCourse(courseId)
    }

    suspend fun saveCourse(course: List<Course>){
        repository.saveCourse(course)
    }

    fun fetchSavedCourses(){
        repository.fetchCourses()

    }
}