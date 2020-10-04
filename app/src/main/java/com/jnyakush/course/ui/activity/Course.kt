package com.jnyakush.course.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jnyakush.course.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Course : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_activity)
    }


}