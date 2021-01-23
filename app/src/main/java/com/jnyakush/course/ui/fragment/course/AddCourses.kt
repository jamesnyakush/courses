package com.jnyakush.course.ui.fragment.course

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.jnyakush.course.R
import com.jnyakush.course.ui.viewmodel.CourseViewModel
import com.jnyakush.course.utils.Resource
import com.jnyakush.course.utils.toast
import kotlinx.android.synthetic.main.add_courses_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber


class AddCourses : Fragment(R.layout.add_courses_fragment) {

    private val viewModel : CourseViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeCourseResponse(view)


        add_course.setOnClickListener {
            onValidation()
        }
    }

    private fun observeCourseResponse(view: View) {
        viewModel.courseResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {

                        requireContext().toast(it.value.message)

                        Navigation.findNavController(view)
                            .navigate(AddCoursesDirections.actionAddCoursesToCourses())
                    }
                }

                is Resource.Failure -> {
                    Timber.d(it.errorBody.toString())
                }
            }
        })
    }

    private fun onValidation() {
        val coursecode = course_code.text.toString().trim()
        val coursename = course_name.text.toString().trim()
        val description = description.text.toString().trim()
        val instructor = instructor.text.toString().trim()

        if (coursecode.isEmpty() || coursename.isEmpty() ||
            description.isEmpty() || instructor.isEmpty()
        ) {
            requireContext().toast("All Fields are Required")
            return
        }

        viewModel.addCourse(coursecode, coursename, description, instructor)
    }
}