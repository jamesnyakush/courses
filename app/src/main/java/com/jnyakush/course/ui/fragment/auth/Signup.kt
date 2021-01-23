package com.jnyakush.course.ui.fragment.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.jnyakush.course.R
import com.jnyakush.course.ui.viewmodel.AuthViewModel
import com.jnyakush.course.utils.Resource
import com.jnyakush.course.utils.toast
import kotlinx.android.synthetic.main.signup_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber


class Signup : Fragment(R.layout.signup_fragment), View.OnClickListener {

    private val viewModel : AuthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.registerResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        Navigation.findNavController(view)
                            .navigate(SignupDirections.actionSignupToSignin())

                        Timber.d(it.value.message)
                    }
                }

                is Resource.Failure -> {
                    Timber.d(it.errorBody.toString())
                }
                else -> Timber.d("Indeed")
            }
        })

        has_account.setOnClickListener(this)
        reg_btn.setOnClickListener(this)
    }

    private fun onValidate() {
        val firstname = first_name.text.toString().trim()
        val lastname = last_name.text.toString().trim()
        val email = reg_email.text.toString().trim()
        val phone = phone.text.toString().trim()
        val password = reg_pass.text.toString().trim()

        if (firstname.isEmpty() || lastname.isEmpty()
            || email.isEmpty() || phone.isEmpty()
            || password.isEmpty()
        ) {
            requireContext().toast("All Fields Required")
            return
        }

        viewModel.signUp(firstname, lastname, email, phone, password)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.has_account -> {
                Navigation.findNavController(v).navigate(SignupDirections.actionSignupToSignin())
            }

            R.id.reg_btn -> {
                onValidate()
            }
        }
    }
}