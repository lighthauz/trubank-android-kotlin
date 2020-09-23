package com.trusona.trubank.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andro.indie.school.common.base.ResponseResult
import com.andro.indie.school.common.base.ResponseWrapper
import com.trusona.trubank.http.datasource.RegistrationDataSource
import com.trusona.trubank.http.model.Registration
import kotlinx.coroutines.launch

class RegistrationViewModel(private val registrationDataSource: RegistrationDataSource) :
    ViewModel() {

    private val _registrationResult =
        MutableLiveData<ResponseResult<ResponseWrapper<Registration>>>()
    val registrationResult: LiveData<ResponseResult<ResponseWrapper<Registration>>> get() = _registrationResult

    fun create() {
        viewModelScope.launch {
            val response = registrationDataSource.create(this)
            _registrationResult.value = response.value
        }
    }

    fun get(registrationIdentifier: String) {
        viewModelScope.launch {
            val response = registrationDataSource.get(registrationIdentifier, this)
            _registrationResult.value = response.value
        }
    }
}