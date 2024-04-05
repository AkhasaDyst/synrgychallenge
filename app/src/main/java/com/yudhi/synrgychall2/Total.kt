package com.yudhi.synrgychall2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Total : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)
        var totalharga = intent.getIntExtra("BUNDLE_TOTAL", 0)

        val tvTotal = findViewById<TextView>(R.id.tvtotal)
        tvTotal.text = totalharga.toString()

    }
}