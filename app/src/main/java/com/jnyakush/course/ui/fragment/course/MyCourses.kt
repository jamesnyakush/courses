package com.jnyakush.course.ui.fragment.course

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jnyakush.course.R
import com.jnyakush.course.ui.adapter.MyCoursesAdapter
import com.jnyakush.course.ui.viewmodel.MyCoursesViewModel
import com.jnyakush.course.utils.Resource
import com.jnyakush.course.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.my_courses_fragment.*
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MyCourses : Fragment(R.layout.my_courses_fragment) {

    private val viewModel by viewModels<MyCoursesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeMyCourses()

        viewModel.myCourses()
    }

    /**
     *
     *
     */
    private fun observeMyCourses() {
        viewModel.myCourseResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        viewModel.saveMyCourse(it.value.studentCourses)
                        recycler_my_courses.apply {
                            layoutManager = LinearLayoutManager(requireContext())
                            hasFixedSize()
                            adapter = MyCoursesAdapter(it.value.studentCourses)
                        }
                    }
                }

                is Resource.Failure -> {
                    Timber.d(it.errorBody.toString())
                    requireContext().toast("Failed Fetching")
                }
            }
        })
    }
}