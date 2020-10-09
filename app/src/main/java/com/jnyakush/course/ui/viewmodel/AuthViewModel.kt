package com.jnyakush.course.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnyakush.course.data.repository.AuthRepository
import com.jnyakush.course.data.retrofit.response.LoginResponse
import com.jnyakush.course.utils.Resource
import kotlinx.coroutines.launch
import timber.log.Timber


class AuthViewModel @ViewModelInject constructor(
    private val repository: AuthRepository
) : ViewModel() {


    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun signIn(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.signInUser(email, password)
    }

    fun saveAuthToken(token: String) {
        repository.saveToken(token)
    }

    fun fetchToken() {
        Timber.tag("James").d(repository.fetchToken().toString())

    }


    fun signUp(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) = viewModelScope.launch {

        repository.signUpUser(firstname, lastname, email, phone, password)

    }

}