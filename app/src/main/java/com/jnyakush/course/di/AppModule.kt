package com.jnyakush.course.di

import android.content.Context
import com.jnyakush.course.utils.AuthInterceptor
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.SessionManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object AppModule {


    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    fun providesApiClient(retrofit: Retrofit): ApiClient =
        retrofit.create(ApiClient::class.java)


    /**
     * Initialize OkhttpClient with our interceptor
     */
    fun providesOkhttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()



    fun providesAuthInterceptor(sessionManager: SessionManager): AuthInterceptor =
        AuthInterceptor(sessionManager)



    fun providesSessionManager(context: Context): SessionManager =
        SessionManager(context)

}
