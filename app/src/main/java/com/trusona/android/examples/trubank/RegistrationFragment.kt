package com.trusona.android.examples.trubank

import android.app.AlertDialog
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationFragment : Fragment() {

    lateinit var deviceIdentifier: String

    companion object {
        fun newInstance(deviceIdentifier: String): RegistrationFragment {
            val bundle = Bundle()
            bundle.putString("deviceIdentifier", deviceIdentifier)

            val registrationFragment = RegistrationFragment()
            registrationFragment.arguments = bundle
            return registrationFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val bundle: Bundle?

        if (savedInstanceState == null) {
            bundle = arguments
        } else {
            bundle = savedInstanceState
        }
        Log.d("bundle", bundle.toString())
        val deviceIdentifierOptional = bundle?.getString("deviceIdentifier")
        Log.d("deviceIdentifier", deviceIdentifierOptional)
        if (deviceIdentifierOptional != null) {
            deviceIdentifier = deviceIdentifierOptional
        } else {
            throw RuntimeException("Device identifier was not set")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val emailAddressInput = view.findViewById<EditText>(R.id.email_address)
        val registrationButton = view.findViewById<View>(R.id.register)
        registrationButton.setOnClickListener {
            val emailAddress = emailAddressInput.editableText.toString()

            val registrationRequest = RegistrationRequest(deviceIdentifier, emailAddress)
            val call = TrubankClient.service.register(registrationRequest)
            call.enqueue(object : Callback<RegistrationResponse> {
                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Log.e("RegistrationFragment", "onFailure")
                }

                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                    Log.d("RegistrationFragment", response.body().toString())
                    getDeviceIdentifier(response.body()!!.id)
                }
            })
        }
        return view
    }

    fun getDeviceIdentifier(registrationIdentifier: String) {
        val call = TrubankClient.service.getRegistration(registrationIdentifier)
        call.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                AlertDialog.Builder(activity).setMessage("Error getting the registration status").show()
            }

            override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                Log.d("RegistrationFragment", response.body().toString())
                StatusPoller((activity as TrubankActivity?)!!, response.body()!!.id).execute()
            }
        })
    }

    class StatusPoller(private val activity: TrubankActivity, private val registrationIdentifier: String) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void?): Void? {
            do {
                val call = TrubankClient.service.getRegistration(registrationIdentifier)
                val response = call.execute()
            } while (!response.body()!!.isCompleted)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            activity.supportFragmentManager.beginTransaction().replace(activity.mainContent, HomeFragment()).commit()
        }
    }
}