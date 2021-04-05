package com.jnyakush.course.ui.viewmodel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jnyakush.course.data.db.AppDatabase
import com.jnyakush.course.data.db.dao.CourseDao
import com.jnyakush.course.data.repository.CourseRepository
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.utils.SessionManager
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CourseViewModelTest : TestCase() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var courseDao: CourseDao
    lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    @Before
    public override fun setUp() {
        super.setUp()

        val ctx = ApplicationProvider.getApplicationContext<Context>()

        val db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase::class.java).allowMainThreadQueries()
            .build()

        val repository = CourseRepository(apiClient, courseDao, sessionManager)

        courseViewModel = CourseViewModel(repository)

    }

    @Test
    fun testCourseViewModel() {

    }
}