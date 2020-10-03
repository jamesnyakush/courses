package com.jnyakush.course.data.retrofit.response

import com.google.gson.annotations.SerializedName
import com.jnyakush.course.data.db.entity.Course

data class CoursesResponse(
    @SerializedName("courses") val courses: List<Course>
)