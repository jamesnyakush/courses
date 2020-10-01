package com.jnyakush.course.data.db.models

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("course_code") var courseCode: String,
    @SerializedName("course_id") var courseId: String,
    @SerializedName("course_name") var courseName: String,
    @SerializedName("description") var description: String,
    @SerializedName("instructor") var instructor: String
)