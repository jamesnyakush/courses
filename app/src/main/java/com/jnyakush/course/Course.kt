package com.jnyakush.course

import android.app.Application
import androidx.annotation.Nullable
import dagger.hilt.android.HiltAndroidApp
import org.jetbrains.annotations.NotNull
import timber.log.Timber

@HiltAndroidApp
class Course : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }



    /**
     *  We will use Timber to log this logs wont project on production mode
     *  For more info visit https://github.com/JakeWharton/timber
     */
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