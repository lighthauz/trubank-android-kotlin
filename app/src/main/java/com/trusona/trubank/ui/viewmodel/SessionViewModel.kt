package com.trusona.trubank.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andro.indie.school.common.base.ResponseResult
import com.andro.indie.school.common.base.ResponseWrapper
import com.trusona.trubank.http.datasource.SessionDataSource
import com.trusona.trubank.http.model.SessionRequest
import com.trusona.trubank.http.model.SessionResponse
import kotlinx.coroutines.launch

class SessionViewModel(private val sessionDataSource: SessionDataSource) : ViewModel() {

    private val _sessionResponse =
        MutableLiveData<ResponseResult<ResponseWrapper<SessionResponse>>>()
    val sessionResponse: LiveData<ResponseResult<ResponseWrapper<SessionResponse>>> get() = _sessionResponse

    fun create(
        sessionRequest: SessionRequest
    ) {
        viewModelScope.launch {
            val response = sessionDataSource.create(sessionRequest, this)
            _sessionResponse.value = response.value
        }
    }
}