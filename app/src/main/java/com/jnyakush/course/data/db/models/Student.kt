package com.jnyakush.course.data.db.models

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("date_of_birth") var Dob: String? = null,
    @SerializedName("email") var email: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("phone_number") var phoneNumber: String,
    @SerializedName("student_id") var studentId: String
)