package com.jnyakush.course.data.repository

import com.jnyakush.course.data.retrofit.ApiClient

class CourseRepository(
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