package com.jnyakush.course

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Course : Application() {

    override fun onCreate() {
        super.onCreate()

        initStetho()
        initTimber()
    }


    private fun initStetho() {
        println("Welcome to Stetho")
    }

    private fun initTimber() {
        println("Welcome to Timber")
    }
}