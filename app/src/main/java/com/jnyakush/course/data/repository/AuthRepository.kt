package com.jnyakush.course.data.repository

import com.jnyakush.course.data.retrofit.ApiClient
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val apiClient: ApiClient
) {

    suspend fun signInUser(
        email: String,
        password: String
    ) {
        apiClient.loginStudent(email, password)
    }

    suspend fun signUpUser(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) {
        apiClient.registerStudent(firstname, lastname, email, phone, password)
    }
}
