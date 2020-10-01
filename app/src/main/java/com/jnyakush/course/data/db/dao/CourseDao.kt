package com.jnyakush.course.data.db.dao

import com.jnyakush.course.data.db.models.Course


interface CourseDao {

    suspend fun insert(course: Course): Long

    suspend fun getCourses()
}