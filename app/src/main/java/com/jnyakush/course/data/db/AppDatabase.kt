package com.jnyakush.course.data.db

import com.jnyakush.course.data.db.dao.CourseDao


abstract class AppDatabase {

    abstract fun courseDao(): CourseDao
}