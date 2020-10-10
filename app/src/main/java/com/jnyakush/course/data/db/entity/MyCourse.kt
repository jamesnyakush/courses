package com.jnyakush.course.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "my_courses")
data class MyCourse(
    @PrimaryKey(autoGenerate = false) @SerializedName("course_id") var courseId: String,
    @SerializedName("course_code") var courseCode: String,
    @SerializedName("course_name") var courseName: String,
    @SerializedName("description") var description: String,
    @SerializedName("instructor") var instructor: String
)