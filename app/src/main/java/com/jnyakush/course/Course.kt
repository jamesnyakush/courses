package com.jnyakush.course

import android.app.Application
import androidx.annotation.Nullable
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
import org.jetbrains.annotations.NotNull
import timber.log.Timber

@HiltAndroidApp
class Course : Application() {

    override fun onCreate() {
        super.onCreate()

        initStetho()
        initTimber()
    }


    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
    }
}