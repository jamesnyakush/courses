package com.jnyakush.course.utils

import android.content.Context
import android.content.SharedPreferences
import com.jnyakush.course.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager(context: Context) {

    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)


    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    /**
     *
     */
    fun saveStudentId(id: String) {
        val editor = prefs.edit()
        editor.putString(STUDENT_ID_TOKEN, id)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun fetchStudentId(): String? {
        return prefs.getString(STUDENT_ID_TOKEN, null)
    }


    companion object {
        const val USER_TOKEN = "user_token"
        const val STUDENT_ID_TOKEN = "student_id_token"
    }
}