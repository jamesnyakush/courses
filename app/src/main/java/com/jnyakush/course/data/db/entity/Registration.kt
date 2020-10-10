package com.jnyakush.course.data.db.entity

import com.google.gson.annotations.SerializedName

data class Registration(
    @SerializedName("course_id") val courseId: String,
    @SerializedName("student_id") val studentId: String
)