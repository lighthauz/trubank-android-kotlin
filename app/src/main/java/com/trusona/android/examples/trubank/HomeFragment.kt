package com.trusona.android.examples.trubank

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val scannerButton = view.findViewById<Button>(R.id.trucode)
        scannerButton.setOnClickListener {
            (activity as TrubankActivity).supportFragmentManager.beginTransaction()
                .replace((activity as TrubankActivity).mainContent, TrucodeContainerFragment()).commit()
        }
        return view
    }


}
