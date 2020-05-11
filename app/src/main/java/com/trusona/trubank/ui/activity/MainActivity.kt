package com.trusona.trubank.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.trusona.android.sdk.Trusona
import com.trusona.trubank.R
import com.trusona.trubank.Trusona.DeviceIdenfitierRequester
import com.trusona.trubank.databinding.ActivityMainBinding
import com.trusona.trubank.ui.viewmodel.RegistrationViewModel
import com.trusona.trubank.ui.viewmodel.SessionViewModel
import com.trusona.trubank.ui.viewmodel.ViewModelModule
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val registrationViewModel by viewModel<RegistrationViewModel>()
    private val sessionViewModel by viewModel<SessionViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.bottomAppBar)
        getDeviceIdentifier()
    }

    fun getDeviceIdentifier(){
        val trusona = Trusona()
        trusona.getDeviceIdentifier(this, DeviceIdenfitierRequester())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.nav_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.share -> {
                showBottomSheet()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showBottomSheet() {
        val view = LayoutInflater.from(this).inflate(R.layout.activity_test, null)
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        dialog.setContentView(view)

        dialog.show()
    }

    fun loadModules() {
        ViewModelModule.loadModules()
    }
}
