package com.jnyakush.course.data.repository

import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.BaseRepository
import com.jnyakush.course.utils.SessionManager
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val sessionManager: SessionManager
) : BaseRepository() {

    suspend fun signInUser(
        email: String,
        password: String
    ) = safeApiCall {
        apiClient.loginStudent(email, password)
    }


    fun saveToken(token: String) {
        sessionManager.saveAuthToken(token)
    }

    suspend fun signUpUser(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) = safeApiCall {
        apiClient.registerStudent(firstname, lastname, email, phone, password)
    }


}
