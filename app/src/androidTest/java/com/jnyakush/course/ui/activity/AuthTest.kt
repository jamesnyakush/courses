package com.jnyakush.course.ui.activity

import androidx.test.core.app.ActivityScenario
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
class AuthTest {

    @get:Rule
    val activityRule =  ActivityScenarioRule(Auth::class.java)

    @Test
    fun is_activity_in_view() {

        onView(withId(R.id.auth)).check(matches(isDisplayed()))
    }

    @Test
    fun is_fragment_in_view() {
        onView(withId(R.id.fragment)).check(matches(isDisplayed()))
    }
}