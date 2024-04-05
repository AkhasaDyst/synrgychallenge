package com.yudhi.synrgychall2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import com.yudhi.synrgychall2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var harga: Int = 0
    private var tip: Double = 0.0
    private var sum: Double = 0.0
    private var totalharga: Int = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("lifecycle", "onCreate")
        setContentView(R.layout.activity_main)
        val switch: SwitchMaterial = findViewById(R.id.switchtheme)

        // Check the current theme mode and update the switch accordingly
        switch.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Attach a listener to the switch to toggle theme mode
        switch.setOnCheckedChangeListener { _, isChecked ->
            setThemeMode(isChecked)
        }
        val radiogroup = findViewById<RadioGroup>(R.id.radio)

        radiogroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                tip = when (checkedId) {
                    R.id.radiotip -> 0.2
                    R.id.radiotip2 -> 0.18
                    R.id.radiotip3 -> 0.15
                    else -> 0.0 // Handle default case
                }
            }
        })

        val btnMoveActivity: Button = findViewById(R.id.btncal)
        btnMoveActivity.setOnClickListener{
            val editText = findViewById<EditText>(R.id.etform)
            harga = Integer.parseInt(editText.getText().toString())

            sum = harga.toDouble() + (harga.toDouble() * tip)
            totalharga = sum.toInt()

            val bundle = Bundle ()
            bundle.putInt("BUNDLE_HARGA", harga)
            bundle.putDouble("BUNDLE_TIP", tip)
            bundle.putInt("BUNDLE_TOTAL", totalharga)

            val intent = Intent(this, Total::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        // FRAGMENT
        changeFragment(fragment, simple)
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "onDestroy")
    }

    private fun setThemeMode(isNightMode: Boolean) {
        val mode = if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(mode)
    }

}