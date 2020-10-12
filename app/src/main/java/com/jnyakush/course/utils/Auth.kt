package com.jnyakush.course.utils

import okhttp3.Interceptor
import okhttp3.Response


/**
 * Interceptor to add auth token to requests
 */
class Auth(
    private val userPreferences: UserPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request


        requestBuilder.addHeader("Authorization", "Bearer ${userPreferences.authToken}")

        return chain.proceed(requestBuilder.build())
    }
}