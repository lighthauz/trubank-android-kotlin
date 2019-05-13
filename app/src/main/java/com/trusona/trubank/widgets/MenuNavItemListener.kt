package com.trusona.trubank.widgets

import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.trusona.trubank.R
import com.trusona.trubank.ui.activity.HomeActivity

class MenuNavItemListener(private val homeActivity: HomeActivity) :
    NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.no_password_login -> {
                // Handle the camera action
            }
            R.id.add_drivers_license -> {

            }
            R.id.settings -> {

            }
            R.id.sign_out -> {

            }
            R.id.accounts -> {

            }
        }
        val drawerLayout: DrawerLayout = homeActivity.findViewById(R.id.drawerLayout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}