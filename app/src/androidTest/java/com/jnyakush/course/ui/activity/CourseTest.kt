package com.jnyakush.course.ui.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.jnyakush.course.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class CourseTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(Course::class.java)

    @Test
    fun is_toolbar_visible() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
    }

    @Test
    fun is_navigation_view_visible() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
    }
}