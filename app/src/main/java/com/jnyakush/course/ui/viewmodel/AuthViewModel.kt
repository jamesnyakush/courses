package com.jnyakush.course.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnyakush.course.data.repository.AuthRepository
import com.jnyakush.course.data.retrofit.response.LoginResponse
import com.jnyakush.course.data.retrofit.response.RegisterResponse
import com.jnyakush.course.utils.Resource
import kotlinx.coroutines.launch


class AuthViewModel @ViewModelInject constructor(
    private val repository: AuthRepository
) : ViewModel() {


    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    private val _registerResponse: MutableLiveData<Resource<RegisterResponse>> = MutableLiveData()
    val registerResponse: LiveData<Resource<RegisterResponse>>
        get() = _registerResponse

    fun signIn(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.signInUser(email, password)
    }

    suspend fun saveAuthToken(token: String) {
        repository.saveToken(token)
    }


    suspend fun saveStudentId(id: String) {
        repository.saveStudentId(id)
    }

    fun signUp(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) = viewModelScope.launch {
        _registerResponse.value = Resource.Loading
        _registerResponse.value = repository.signUpUser(firstname, lastname, email, phone, password)
    }

}