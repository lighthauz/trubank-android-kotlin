package com.trusona.android.examples.trubank

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trusona.android.registration.device.DeviceStatus
import com.trusona.android.sdk.Trusona
import kotlinx.android.synthetic.main.activity_trubank.*

class TrubankActivity : AppCompatActivity() {

    val TOKEN =
        "eyJraWQiOiI1OTUyYjE5Yi1iODJkLTRjYzQtYjVlMS00ZDU1ODZiMmY3YzQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIwZjAzNDhmMC00NmQ2LTQ3YzktYmE0ZC0yZTdjZDdmODJlM2UiLCJuYmYiOjE1MTk5MjEyNzYsImF0aCI6IlJPTEVfVFJVU1RFRF9SUF9DTElFTlQiLCJpc3MiOiJ0czo5ZjhmNTkyMC1hYzRhLTQxNWYtYTgxMC1iMzdmOTY5OTNiZGYiLCJleHAiOjQ2NDE5ODUyNzYsImlhdCI6MTUxOTkyMTI3NiwianRpIjoiMTg0ZDljZTktZTFhMi00MDMyLTkxMDEtOGE0MDk2MDQxYzY3In0.AwZL3ibWilAPKfNMxeHKrGR6_6s2EgLJADN7pHRG4-np4xEKzPz58OdJ_3mo46XTiOaTfZmKG_O4y1HYpkkm-Miqw-ciEx4DhRKOcGMqGeUFiB9gdYGCp_km6Cfg5RPJtHyHsbKyqEu-L4ZHYluvV2OVrlMCcDZGpzuXTxiWkRU4SRYy0XscnCkefPRfY6klxkPb2S7a_HeEG_Olf7hNEiXUCoIuZOsmIszoKPSRCXGWIEkTTJ8FPFgXBuBqAettbfEdUpLcGW5vXCLbZ-80iSq6BaAWc9WYwj-PH7K4jGrPblgoURYL8jaU7CFqrG9aPXleML__66w705Ao1NYZpg"
    val SECRET =
        "2d1d5626ec24cf3d461a99fe1e309dce7937b1b3ca1b6b35ff77cf91ead0f81164df3d97eb5da3f0ba6ef15127a45c97cf91e102e4906c29e04d096a26d70527"
    val trusona = Trusona(TOKEN, SECRET)
    val mainContent = R.id.main_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trubank)
        setSupportActionBar(toolbar)

        getDeviceIdentifier()
    }

    fun getDeviceIdentifier() {
        trusona.getDeviceIdentifier(this) {response ->
            when (response.deviceStatus) {

                DeviceStatus.ACTIVE_DEVICE -> {
                    Log.d("TrubankActivity", "ACTIVE_DEVICE")
                    supportFragmentManager.beginTransaction().replace(mainContent, HomeFragment()).commit()
                }
                DeviceStatus.INACTIVE_DEVICE,
                DeviceStatus.NEW_DEVICE -> {
                    Log.d("TrubankActivity", "NEW_DEVICE")
                    supportFragmentManager.beginTransaction().replace(mainContent, RegistrationFragment()).commit()
                }


                DeviceStatus.INVALID_CREDENTIALS -> Log.d("TrubankActivity", "INVALID_CREDENTIALS")
                DeviceStatus.INVALID_DEVICE -> Log.d("TrubankActivity", "INVALID_DEVICE")
                DeviceStatus.INVALID_RELYING_PARTY -> Log.d("TrubankActivity", "INVALID_RELYING_PARTY")

                DeviceStatus.SERVER_ERROR -> Log.d("TrubankActivity", "SERVER_ERROR")
                DeviceStatus.UNKNOWN -> Log.d("TrubankActivity", "UNKNOWN")
            }
        }
    }

}
