package com.jnyakush.course.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.jnyakush.course.data.db.dao.CourseDao
import com.jnyakush.course.data.db.entity.Course
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {

    private lateinit var appDatabase: AppDatabase
    private lateinit var courseDao: CourseDao


    @Before
    public override fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        courseDao = appDatabase.courseDao()
    }

    @After
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    fun writeAndReadCourse() = runBlocking {
        val course = Course(
            "1",
            "ABCD",
            "Alphabets",
            "Learning to say alphabets",
            "jnyakush"
        )

        courseDao.addCourse(course)

        val courses = courseDao.getCourses()

        assertThat(courses.value?.contains(course)).isTrue()
    }
}