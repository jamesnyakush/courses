package com.jnyakush.course.data.repository

import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.BaseRepository
import com.jnyakush.course.utils.SessionManager
import com.jnyakush.course.utils.UserPreferences
import javax.inject.Inject



/**
 *  This is AuthRepository class that acts as our data source
 *
 * @param apiClient
 * @param userPreferences
 *
 */
class AuthRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val sessionManager: SessionManager
) : BaseRepository() {

    /**
     * @param email
     * @param password
     *
     * @return [safeApiCall]
     */
    suspend fun signInUser(
        email: String,
        password: String
    ) = safeApiCall {
        apiClient.loginStudent(email, password)
    }

    /**
     * @param firstname
     * @param lastname
     * @param email
     * @param phone
     * @param password
     *
     * @return [safeApiCall]
     */
    suspend fun signUpUser(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) = safeApiCall {
        apiClient.registerStudent(firstname, lastname, email, phone, password)
    }

    /**
     * @param token
     */
     fun saveToken(token: String) {
        sessionManager.saveAuthToken(token)
    }

    /**
     * @param id
     */
     fun saveStudentId(id: String) {
        sessionManager.saveStudentId(id)
    }
}
