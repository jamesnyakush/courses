package com.jnyakush.course.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnyakush.course.R
import com.jnyakush.course.data.db.entity.MyCourse
import kotlinx.android.synthetic.main.my_course_item.view.*

class MyCoursesAdapter(
    var courses: List<MyCourse>
) : RecyclerView.Adapter<MyCoursesAdapter.MyCourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyCourseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.my_course_item, parent, false)
    )

    override fun getItemCount() = courses.size


    override fun onBindViewHolder(holder: MyCourseViewHolder, position: Int) {
        var course = courses[position]

        holder.itemView.apply {
            course_id.text = course.courseId
            course_code.text = course.courseCode
            course_name.text = course.courseName
            description.text = course.description
            instructor.text = course.instructor
        }
    }

    class MyCourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}