package com.jnyakush.course.di

/*
import android.content.Context
import androidx.room.Room
import com.jnyakush.course.data.db.AppDatabase
import com.jnyakush.course.data.db.dao.CourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "course_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesCourseDao(appDatabase: AppDatabase): CourseDao =
        appDatabase.courseDao()


}*/
