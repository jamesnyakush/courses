package com.jnyakush.course.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jnyakush.course.data.db.entity.Course
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCourse(courses: Course)

    @Query("SELECT * FROM courses")
    fun getCourses(): Flow<List<Course>>
}