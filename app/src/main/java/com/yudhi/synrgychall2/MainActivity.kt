package com.yudhi.synrgychall2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val switch: SwitchMaterial = findViewById(R.id.switchtheme)

        // Check the current theme mode and update the switch accordingly
        switch.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Attach a listener to the switch to toggle theme mode
        switch.setOnCheckedChangeListener { _, isChecked ->
            setThemeMode(isChecked)
        }
    }

    private fun setThemeMode(isNightMode: Boolean) {
        val mode = if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(mode)
    }

}