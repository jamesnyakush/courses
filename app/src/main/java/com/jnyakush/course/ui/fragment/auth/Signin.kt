package com.jnyakush.course.ui.fragment.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.jnyakush.course.R
import com.jnyakush.course.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.signin_fragment.*


@AndroidEntryPoint
class Signin : Fragment(R.layout.signin_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onValidate()

    }

    private fun onValidate() {
        val email = log_email.text.toString().trim()
        val password = log_password.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            requireContext().toast("All Fields Required")
        }
    }
}