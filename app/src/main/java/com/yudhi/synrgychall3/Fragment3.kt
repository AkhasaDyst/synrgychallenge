package com.yudhi.synrgychall3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yudhi.synrgychall3.databinding.Fragment1Binding
import com.yudhi.synrgychall3.databinding.Fragment2Binding
import com.yudhi.synrgychall3.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private var _binding: Fragment3Binding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= Fragment3Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text3 = Fragment3Args.fromBundle(arguments as Bundle).nama
        binding.tvfrag3.text = "Hasilnya: $text3"
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}