package com.jnyakush.course.data.db.dao

import androidx.lifecycle.LiveData
import com.jnyakush.course.data.db.entity.Course


interface CourseDao {

    suspend fun insert(courses: List<Course>)

    suspend fun getCourses(): LiveData<List<Course>>
}