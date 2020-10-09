package com.jnyakush.course.data.repository


import com.jnyakush.course.data.db.dao.CourseDao
import com.jnyakush.course.data.db.entity.Course
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.BaseRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject


/**
 * This is CourseRepository
 *
 *
 * @param apiClient
 * @param courseDao
 * */
class CourseRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val courseDao: CourseDao
) : BaseRepository() {


    /**
     *
     * @param courseCode
     * @param courseName
     * @param description
     * @param instructor
     * */
    suspend fun postCourse(
        courseCode: String,
        courseName: String,
        description: String,
        instructor: String
    ) {
        apiClient.createCourse(courseCode, courseName, description, instructor)
    }

    suspend fun getCourse() = safeApiCall {
        apiClient.getCourses()
    }

    suspend fun saveCourse(course: Course) = courseDao.saveCourse(course)


    fun fetchCourses(): Flow<List<Course>> = courseDao.getCourses()
}