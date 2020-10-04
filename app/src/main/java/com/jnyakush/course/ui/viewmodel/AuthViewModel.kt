package com.jnyakush.course.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.jnyakush.course.data.repository.AuthRepository
import com.jnyakush.course.utils.SessionManager


class AuthViewModel @ViewModelInject constructor(
    private val repository: AuthRepository,
    private val sessionManager: SessionManager
) : ViewModel() {


    fun signIn(email: String, password: String) {

        if (email.isEmpty() || password.isEmpty()) {
            return
        }

        //repository.signInUser(email, password)
        //sessionManager.saveAuthToken(loginResponse!!.accessToken)
    }

    fun signUp(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) {
        if (firstname.isEmpty() || lastname.isEmpty()
            || email.isEmpty() || phone.isEmpty() ||
            password.isEmpty()
        ) {
            return
        }

        //repository.signUpUser(firstname, lastname, email, phone, password)

    }

}