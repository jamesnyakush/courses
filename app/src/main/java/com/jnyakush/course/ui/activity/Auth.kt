package com.jnyakush.course.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jnyakush.course.R


class Auth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.auth_activity)
    }

}