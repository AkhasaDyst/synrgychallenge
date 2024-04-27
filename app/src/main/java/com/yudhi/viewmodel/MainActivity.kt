package com.yudhi.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yudhi.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewmodel.points.observe(this, Observer {
            binding.tvSkorA.text = it.toString()
        })
        viewmodel.teams.observe(this, Observer {
            binding.tvTeamA.text = it
        })
        incrementPoint()
    }


    private fun incrementPoint(){
        binding.btnPlus1.setOnClickListener{
            viewmodel._points.value = viewmodel._points.value?.plus(1)
        }
        binding.btnPlus2.setOnClickListener{
            viewmodel._points.value = viewmodel._points.value?.plus(2)
        }
        binding.btnPlus3.setOnClickListener{
            viewmodel._points.value = viewmodel._points.value?.plus(3)
        }
        binding.btnReset.setOnClickListener{
            viewmodel.point = 0
            viewmodel._points.value = viewmodel.point
        }
    }
}