package com.jnyakush.course.ui.fragment.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.jnyakush.course.R
import com.jnyakush.course.ui.activity.Course
import com.jnyakush.course.ui.viewmodel.AuthViewModel
import com.jnyakush.course.utils.Resource
import com.jnyakush.course.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.signin_fragment.*
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class Signin : Fragment(R.layout.signin_fragment), View.OnClickListener {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        viewModel.saveAuthToken(it.value.accessToken)
                        viewModel.saveStudentId(it.value.studentId)
                        requireContext().startActivity(Intent(requireContext(), Course::class.java))
                        Timber.d(it.value.message)
                    }
                }
                is Resource.Failure -> {
                    Timber.d(it.errorBody.toString())
                }
            }
        })

        login_btn.setOnClickListener(this)
        need_account.setOnClickListener(this)

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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.need_account -> {
                Navigation.findNavController(v).navigate(SigninDirections.actionSigninToSignup())
            }

            R.id.login_btn -> {
                onValidate()
            }
        }
    }
}