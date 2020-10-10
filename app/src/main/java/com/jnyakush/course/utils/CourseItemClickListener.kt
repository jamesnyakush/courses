package com.jnyakush.course.utils

import com.jnyakush.course.data.db.entity.Course

interface CourseItemClickListener {
    fun onItemClick(course: Course)
}