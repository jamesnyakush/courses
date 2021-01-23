package com.jnyakush.course.data.repository

import androidx.lifecycle.LiveData
import com.jnyakush.course.data.db.dao.CourseDao
import com.jnyakush.course.data.db.entity.MyCourse
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.BaseRepository
import com.jnyakush.course.utils.SessionManager


class MyCoursesRepository(
    private val apiClient: ApiClient,
    private val sessionManager: SessionManager,
    private val courseDao: CourseDao
) : BaseRepository() {


    /**
     *
     */
    suspend fun myCourses() = safeApiCall {
        apiClient.myCourse(sessionManager.fetchStudentId().toString())
    }


    /**
     *
     */
    suspend fun saveMyCourse(course: List<MyCourse>) = courseDao.saveMyCourse(course)


    /**
     *
     */
    fun fetchCourses(): LiveData<List<MyCourse>> = courseDao.getMyCourses()
}