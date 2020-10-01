package com.jnyakush.course.utils

import okhttp3.Interceptor
import okhttp3.Response


/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor(
    private val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}