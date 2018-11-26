package com.trusona.android.examples.trubank

import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.trusona.android.rest.credentials.TruCredentials
import com.trusona.android.sdk.Trusona
import java.io.InputStreamReader

object TrubankCore {
    val trusonaCredentialsJson = "trusona_api.json"
    var trusona: Trusona? = null
    var trusonaCredentials: TruCredentials? = null

    fun initTrusonaCredentials() {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

        trusonaCredentials = gson.fromJson(
            InputStreamReader(
                TrubankCore.javaClass.classLoader.getResourceAsStream(trusonaCredentialsJson)
            ), TruCredentials::class.java
        )
        Log.d("TrubankCore", trusonaCredentials.toString())
        trusona = Trusona(trusonaCredentials!!.apiToken, trusonaCredentials!!.apiSecret)
    }
}