package com.jnyakush.course.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jnyakush.course.data.db.entity.Course

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(courses: List<Course>)

    @Query("SELECT * FROM courses")
    fun getCourses(): LiveData<List<Course>>
}