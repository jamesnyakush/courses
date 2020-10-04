package com.jnyakush.course.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jnyakush.course.data.db.dao.CourseDao
import com.jnyakush.course.data.db.entity.Course

@Database(entities = [Course::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
}