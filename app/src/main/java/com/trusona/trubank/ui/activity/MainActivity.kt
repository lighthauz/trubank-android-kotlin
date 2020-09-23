package com.trusona.trubank.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.trusona.android.sdk.Trusona
import com.trusona.trubank.R
import com.trusona.trubank.Trusona.DeviceIdenfitierRequester
import com.trusona.trubank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private val registrationViewModel by viewModel<RegistrationViewModel>()
//    private val sessionViewModel by viewModel<SessionViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        getDeviceIdentifier()
    }

    private fun getDeviceIdentifier() {
        val trusona = Trusona()
        trusona.getDeviceIdentifier(this, DeviceIdenfitierRequester())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationBar.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.landing -> binding.bottomNavigationBar.visibility = View.GONE
                else -> binding.bottomNavigationBar.visibility = View.VISIBLE
            }
        }
    }
}
