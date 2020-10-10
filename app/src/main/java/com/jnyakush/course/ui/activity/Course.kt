package com.jnyakush.course.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jnyakush.course.BuildConfig
import com.jnyakush.course.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.course_activity.*


@AndroidEntryPoint
class Course : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)
        setContentView(R.layout.course_activity)

        setSupportActionBar(toolbar)

        setupNavigation()
        version_text.text = "v${BuildConfig.VERSION_NAME}"
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(this, R.id.fragment)
        // Update action bar to reflect navigation
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navController)
        navController.addOnDestinationChangedListener { _, destination, _ -> }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onSupportNavigateUp() =
        NavigationUI.navigateUp(findNavController(R.id.fragment), drawer_layout)

}