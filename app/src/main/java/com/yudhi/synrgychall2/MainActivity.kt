package com.yudhi.synrgychall2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate
import com.yudhi.synrgychall2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var harga: Int = 0
    private var tip: Double = 0.0
    private var sum: Double = 0.0
    private var totalharga: Int = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("lifecycle", "onCreate")

        // Check the current theme mode and update the switch accordingly
        binding.switchtheme.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Attach a listener to the switch to toggle theme mode
        binding.switchtheme.setOnCheckedChangeListener { _, isChecked ->
            setThemeMode(isChecked)
        }

        binding.radio.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                tip = when (checkedId) {
                    R.id.radiotip -> 0.2
                    R.id.radiotip2 -> 0.18
                    R.id.radiotip3 -> 0.15
                    else -> 0.0 // Handle default case
                }
            }
        })


        binding.btncal.setOnClickListener{
            harga = Integer.parseInt(binding.etform.getText().toString())

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
        binding.btncalfrag.setOnClickListener {
            val fragment = supportFragmentManager
            val fragmentTransaction = fragment.beginTransaction()
            val fragmentTotal = TotalFragment()

            harga = Integer.parseInt(binding.etform.getText().toString())

            sum = harga.toDouble() + (harga.toDouble() * tip)
            totalharga = sum.toInt()

            val bundle = Bundle()
            bundle.putInt("BUNDLE_HARGA", harga)
            bundle.putDouble("BUNDLE_TIP", tip)
            bundle.putInt("BUNDLE_TOTAL", totalharga)

            fragmentTotal.arguments = bundle
            fragmentTransaction.replace(R.id.fragframe, fragmentTotal)
            fragmentTransaction.commit()
        }
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