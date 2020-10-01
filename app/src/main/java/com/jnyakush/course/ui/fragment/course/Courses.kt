package com.jnyakush.course.ui.fragment.course

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.jnyakush.course.R


class Courses : Fragment(R.layout.courses_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        recycler_courses.apply {
            layoutManager = LinearLayoutManager(this@Courses)
            hasFixedSize()
            adapter = CourseAdapter(response.body()!!.courses)
        }
        */

    }
}