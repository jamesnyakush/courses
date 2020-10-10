package com.jnyakush.course.data.retrofit

import com.jnyakush.course.data.retrofit.response.*
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @FormUrlEncoded
    @POST("register")
    suspend fun registerStudent(
        @Field("first_name") fistName: String,
        @Field("last_name") lastName: String,
        @Field("email") email: String,
        @Field("phone_number") phoneNumber: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun loginStudent(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("courses")
    suspend fun getCourses(): CoursesResponse

    @FormUrlEncoded
    @POST("courses")
    suspend fun createCourse(
        @Field("course_code") courseCode: String,
        @Field("course_name") courseName: String,
        @Field("description") description: String,
        @Field("instructor") instructor: String
    ): CourseResponse

    @FormUrlEncoded
    @POST("register-course")
    suspend fun registerCourse(
        @Field("course_id") courseId: String,
        @Field("student_id") studentId: String
    ): RegCourseResponse


    companion object {
        const val BASE_URL = "https://courses-service.herokuapp.com/"
    }

}