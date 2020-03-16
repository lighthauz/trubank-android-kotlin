package com.trusona.trubank.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.trusona.trubank.R
import com.trusona.trubank.ui.viewmodel.LandingViewModel
import kotlinx.android.synthetic.main.landing_fragment.*

class LandingFragment : Fragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    private lateinit var viewModel: LandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.landing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LandingViewModel::class.java)
        // TODO: Use the ViewModel
        button.setOnClickListener {
            this.activity?.let { it -> Navigation.findNavController(it, R.id.mainNavFragment).navigate(R.id.action_landingFragment_to_homeFragment) }
        }
    }

}
