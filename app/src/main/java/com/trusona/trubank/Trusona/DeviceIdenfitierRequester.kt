package com.trusona.trubank.Trusona

import android.util.Log
import com.trusona.android.registration.device.DeviceIdentifierRequester
import com.trusona.android.registration.device.DeviceIdentifierResponse
import timber.log.Timber

class DeviceIdenfitierRequester: DeviceIdentifierRequester {
    override fun onDeviceIdentifier(deviceIdentifierResponse: DeviceIdentifierResponse) {
        Log.d("deviceIdentifier", deviceIdentifierResponse.deviceIdentifier)

    }
}