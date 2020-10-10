package com.jnyakush.course.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnyakush.course.R
import com.jnyakush.course.data.db.entity.Course
import com.jnyakush.course.utils.CourseItemClickListener
import kotlinx.android.synthetic.main.course_item.view.*

class CourseAdapter(
    var courses: List<Course>,
    var courseItemClickListener: CourseItemClickListener
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CourseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
    )

    override fun getItemCount() = courses.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        var course = courses[position]

        holder.itemView.apply {
            course_id.text = course.courseId
            course_code.text = course.courseCode
            course_name.text = course.courseName
            description.text = course.description
            instructor.text = course.instructor
        }
        holder.itemView.reg_course.setOnClickListener {
            courseItemClickListener.onItemClick(course)
        }

    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}