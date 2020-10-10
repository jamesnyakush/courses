package com.jnyakush.course.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jnyakush.course.data.db.entity.Course
import com.jnyakush.course.data.db.entity.MyCourse

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCourse(courses: Course)

    @Query("SELECT * FROM courses")
    fun getCourses(): LiveData<List<Course>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMyCourse(myCourse: MyCourse)

    @Query("SELECT * FROM my_courses")
    fun getMyCourses(): LiveData<List<MyCourse>>
}