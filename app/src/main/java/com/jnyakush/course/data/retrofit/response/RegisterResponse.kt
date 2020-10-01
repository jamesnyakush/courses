package com.jnyakush.course.data.retrofit.response

import com.google.gson.annotations.SerializedName
import com.jnyakush.course.data.db.models.Student

data class RegisterResponse(
    @SerializedName("message") val message: String,
    @SerializedName("student") val student: Student
)