package com.jnyakush.course.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("message") val message: String,
    @SerializedName("student_id") var studentId: String
)