package com.jnyakush.course.data.retrofit.response

import com.google.gson.annotations.SerializedName
import com.jnyakush.course.data.db.entity.Registration

data class RegCourseResponse(
    @SerializedName("message") val message: String,
    @SerializedName("registration") val registration: Registration
)