package com.trusona.trubank.http.datasource

import androidx.lifecycle.LiveData
import com.andro.indie.school.common.base.ResponseResult
import com.andro.indie.school.common.base.ResponseWrapper
import com.trusona.trubank.http.model.Registration
import com.trusona.trubank.http.service.RegistrationService
import kotlinx.coroutines.CoroutineScope

class RegistrationDataSource(private val registrationService: RegistrationService) :
    BaseDataSource() {

    fun create(scope: CoroutineScope): LiveData<ResponseResult<ResponseWrapper<Registration>>> =
        resultLiveData(scope) {
            getResult {
                registrationService.create()
            }
        }

    fun get(
        registrationIdentifier: String,
        scope: CoroutineScope
    ): LiveData<ResponseResult<ResponseWrapper<Registration>>> = resultLiveData(scope) {
        getResult {
            registrationService.get(registrationIdentifier)
        }
    }
}