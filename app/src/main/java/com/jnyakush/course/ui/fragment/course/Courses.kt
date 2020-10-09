package com.jnyakush.course.ui.fragment.course

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.jnyakush.course.R
import com.jnyakush.course.ui.adapter.CourseAdapter
import com.jnyakush.course.ui.viewmodel.CourseViewModel
import com.jnyakush.course.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.courses_fragment.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Courses : Fragment(R.layout.courses_fragment) {

    private val viewModel by viewModels<CourseViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.coursesResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        recycler_courses.apply {
                            layoutManager = LinearLayoutManager(requireContext())
                            hasFixedSize()
                            adapter = CourseAdapter(it.value.courses)
                        }

                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Failed Fetching", Toast.LENGTH_SHORT).show()
                }
            }
        })
        viewModel.fetchCourses()

        add_courses.setOnClickListener {
            Navigation.findNavController(it).navigate(CoursesDirections.actionCoursesToAddCourses())
        }

    }
}