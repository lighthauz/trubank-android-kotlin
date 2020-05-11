package com.trusona.trubank.http.datasource

import androidx.lifecycle.LiveData
import com.andro.indie.school.common.base.ResponseResult
import com.andro.indie.school.common.base.ResponseWrapper
import com.trusona.trubank.http.model.SessionRequest
import com.trusona.trubank.http.model.SessionResponse
import com.trusona.trubank.http.service.SessionService
import kotlinx.coroutines.CoroutineScope

class SessionDataSource(private val sessionService: SessionService) :
    BaseDataSource() {

    fun create(
        request: SessionRequest,
        scope: CoroutineScope
    ): LiveData<ResponseResult<ResponseWrapper<SessionResponse>>> =
        resultLiveData(scope) {
            getResult {
                sessionService.create(request)
            }
        }
}