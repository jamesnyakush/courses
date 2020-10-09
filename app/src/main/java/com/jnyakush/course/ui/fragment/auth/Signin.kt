package com.jnyakush.course.ui.fragment.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.jnyakush.course.R
import com.jnyakush.course.ui.activity.Course
import com.jnyakush.course.ui.viewmodel.AuthViewModel
import com.jnyakush.course.utils.Resource
import com.jnyakush.course.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.signin_fragment.*
import kotlinx.coroutines.launch


@AndroidEntryPoint
class Signin : Fragment(R.layout.signin_fragment) {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        viewModel.saveAuthToken(it.value.accessToken)
                        requireContext().startActivity(Intent(requireContext(), Course::class.java))
                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.fetchToken()

        login_btn.setOnClickListener {
            onValidate()
        }

    }

    private fun onValidate() {
        val email = log_email.text.toString().trim()
        val password = log_password.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            requireContext().toast("All Fields Required")
            return
        }

        viewModel.signIn(email, password)
    }
}