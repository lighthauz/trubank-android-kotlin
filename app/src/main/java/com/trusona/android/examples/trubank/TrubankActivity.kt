package com.trusona.android.examples.trubank

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trusona.android.registration.device.DeviceStatus
import kotlinx.android.synthetic.main.activity_trubank.*

class TrubankActivity : AppCompatActivity() {

    val mainContent = R.id.main_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trubank)
        setSupportActionBar(toolbar)

        getDeviceIdentifier()
    }

    fun showGenericErrorDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setOnDismissListener(DialogInterface::dismiss)
        dialog.setTitle("Error")
        dialog.setMessage("Trusona Service")
        dialog.show()
    }

    fun getDeviceIdentifier() {
        TrubankCore.initTrusonaCredentials()
        TrubankCore.trusona!!.getDeviceIdentifier(this) { response ->
            Log.d("TrubankActivity", response.deviceStatus.name)

            when (response.deviceStatus) {

                DeviceStatus.ACTIVE_DEVICE -> supportFragmentManager.beginTransaction().replace(
                    mainContent,
                    HomeFragment()
                ).commit()

                DeviceStatus.INACTIVE_DEVICE,
                DeviceStatus.NEW_DEVICE ->
                    supportFragmentManager.beginTransaction().replace(
                        mainContent,
                        RegistrationFragment.newInstance(response.deviceIdentifier!!)
                    ).commit()

                DeviceStatus.INVALID_CREDENTIALS,
                DeviceStatus.INVALID_DEVICE,
                DeviceStatus.INVALID_RELYING_PARTY,
                DeviceStatus.SERVER_ERROR,
                DeviceStatus.UNKNOWN -> showGenericErrorDialog()
            }
        }
    }

}