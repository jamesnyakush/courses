package com.jnyakush.course.data.repository


import androidx.lifecycle.LiveData
import com.jnyakush.course.data.db.dao.CourseDao
import com.jnyakush.course.data.db.entity.Course
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.BaseRepository
import com.jnyakush.course.utils.SessionManager


/**
 * This is CourseRepository
 *
 *
 * @param apiClient
 * @param courseDao
 * */
class CourseRepository(
    private val apiClient: ApiClient,
    private val courseDao: CourseDao,
    private val sessionManager: SessionManager
) : BaseRepository() {


    /**
     *
     * @param courseCode
     * @param courseName
     * @param description
     * @param instructor
     */
    suspend fun postCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) = safeApiCall {
        apiClient.createCourse(courseCode, courseName, description, instructor)
    }

    /**
     *
     */
    suspend fun getCourse() = safeApiCall {
        apiClient.getCourses()
    }


    /**
     *
     */
    suspend fun registerCourse(
        courseId: String
    ) = safeApiCall {
        apiClient.registerCourse(courseId, sessionManager.fetchStudentId().toString())
    }


    /**
     *
     */
    suspend fun saveCourse(course: List<Course>) = courseDao.saveCourse(course)


    /**
     *
     */
    fun fetchCourses(): LiveData<List<Course>> = courseDao.getCourses()


}