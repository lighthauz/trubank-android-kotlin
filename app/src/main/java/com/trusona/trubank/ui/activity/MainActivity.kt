package com.trusona.trubank.ui.activity

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.trusona.trubank.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trubank)
        val bar = findViewById(R.id.bottomAppBar) as BottomAppBar
        setSupportActionBar(bar)
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

    fun showBottomSheet(){
        val view = LayoutInflater.from(this).inflate(R.layout.activity_test, null)
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        dialog.setContentView(view)

        dialog.show()
    }
}
