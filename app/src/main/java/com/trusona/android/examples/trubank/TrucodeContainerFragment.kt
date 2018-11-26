package com.trusona.android.examples.trubank

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trusona.android.trucode.camera.trucode.TruCodeHandler

class TrucodeContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trucode_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TrubankCore.trusona!!.loadTruCodeAsChildFragment(this, object : TruCodeHandler{
            override fun fragmentContainerId(): Int {
              return R.id.trucode_container
            }

            override fun acceptRejectLayoutId(): Int? {
                return R.layout.trusonafication_dialog
            }

            override fun onTruCode(p0: Boolean) {
                Log.d("TrucodeContainer", p0.toString())
            }

        })
    }
}
