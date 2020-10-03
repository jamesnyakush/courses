package com.jnyakush.course.data.retrofit.response

import com.google.gson.annotations.SerializedName
import com.jnyakush.course.data.db.entity.Course

data class CourseResponse(
    @SerializedName("course") val course: Course,
    @SerializedName("message") val message: String
)