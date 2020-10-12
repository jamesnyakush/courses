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


    /**
    *  We will use stetho to get a visual structure of our persistence db (room)
    *  For more info visit http://facebook.github.io/stetho/
    *  open Chrome and use this url chrome://inspect/
    *
    */
    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
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