package com.trusona.trubank.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.trusona.trubank.R
import com.trusona.trubank.widgets.MenuNavItemListener
import kotlinx.android.synthetic.main.activity_trubank.*
import kotlinx.android.synthetic.main.app_bar_trubank.*

class TrubankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trubank)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(MenuNavItemListener(this))

        NavigationUI.setupActionBarWithNavController(this, findNavController(this, R.id.mainNavFragment))

    }

    override fun onSupportNavigateUp() = findNavController(this, R.id.mainNavFragment).navigateUp()


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
