package com.jnyakush.course.di

import android.content.Context
import com.jnyakush.course.utils.AuthInterceptor
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.SessionManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object AppModule {


    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    fun provideApiClient(retrofit: Retrofit): ApiClient =
        retrofit.create(ApiClient::class.java)


    /**
     * Initialize OkhttpClient with our interceptor
     */
    fun provideOkhttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

    fun provideAuthInterceptor(sessionManager: SessionManager): AuthInterceptor =
        AuthInterceptor(sessionManager)


    fun provideSessionManager(context: Context): SessionManager =
        SessionManager(context)


}
