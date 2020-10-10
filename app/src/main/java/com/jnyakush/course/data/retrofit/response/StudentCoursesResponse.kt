package com.jnyakush.course.data.retrofit.response

import com.google.gson.annotations.SerializedName
import com.jnyakush.course.data.db.entity.Course

data class StudentCoursesResponse(
    @SerializedName("student_courses") val studentCourses: List<Course>
)