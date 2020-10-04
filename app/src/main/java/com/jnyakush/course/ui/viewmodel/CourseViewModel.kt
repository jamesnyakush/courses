package com.jnyakush.course.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.jnyakush.course.data.repository.CourseRepository


class CourseViewModel @ViewModelInject constructor(
    private val repository: CourseRepository
) : ViewModel() {


    fun addCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) {
        //repository.postCourse(courseCode, courseName, description, instructor)
    }

    fun fetchCourses() {

    }
}