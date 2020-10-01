package com.jnyakush.course.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jnyakush.course.data.repository.CourseRepository


class CourseViewModel(
    private val repository: CourseRepository
) : ViewModel() {


    fun addCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) {

    }

    fun fetchCourses() {

    }
}