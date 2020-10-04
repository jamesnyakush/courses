package com.jnyakush.course.di

import android.content.Context
import com.jnyakush.course.utils.AuthInterceptor
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesApiClient(retrofit: Retrofit): ApiClient =
        retrofit.create(ApiClient::class.java)


    /**
     * Initialize OkhttpClient with our interceptor
     */
    @Provides
    @Singleton
    fun providesOkhttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

    @Provides
    @Singleton
    fun providesAuthInterceptor(sessionManager: SessionManager): AuthInterceptor =
        AuthInterceptor(sessionManager)

    @Provides
    @Singleton
    fun providesSessionManager(@ApplicationContext context: Context): SessionManager =
        SessionManager(context)

}
