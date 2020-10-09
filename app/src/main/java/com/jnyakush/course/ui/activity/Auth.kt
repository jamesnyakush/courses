package com.jnyakush.course.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jnyakush.course.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Auth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.auth_activity)
    }

}