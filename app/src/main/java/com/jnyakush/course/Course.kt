package com.jnyakush.course

import android.app.Application
import androidx.annotation.Nullable
import com.jnyakush.course.di.appModules
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import timber.log.Timber


class Course : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }

    /**
     *  We will use Koin to access modules
     *  For more info visit https://insert-koin.io/
     */
    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@Course)

            val modules = mutableListOf<Module>().apply {
                addAll(appModules)
            }

            modules(modules)
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