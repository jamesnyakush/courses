package com.jnyakush.course.ui.fragment.course

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jnyakush.course.R
import com.jnyakush.course.ui.adapter.MyCoursesAdapter
import com.jnyakush.course.ui.viewmodel.MyCoursesViewModel
import com.jnyakush.course.utils.Resource
import com.jnyakush.course.utils.toast
import kotlinx.android.synthetic.main.my_courses_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber


class MyCourses : Fragment(R.layout.my_courses_fragment) {

    private val viewModel : MyCoursesViewModel by viewModel()

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