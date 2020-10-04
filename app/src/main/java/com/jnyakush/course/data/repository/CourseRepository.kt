package com.jnyakush.course.data.repository

import com.jnyakush.course.data.retrofit.ApiClient
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val apiClient: ApiClient
) {

    suspend fun postCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) {
        apiClient.createCourse(courseCode, courseName, description, instructor)
    }

    suspend fun getCourse() {
        apiClient.getCourses()
    }
}