package com.yudhi.synrgychall3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.yudhi.synrgychall3.databinding.Fragment1Binding
import com.yudhi.synrgychall3.databinding.Fragment2Binding
import com.yudhi.synrgychall3.databinding.Fragment3Binding

class Fragment2 : Fragment() {
    private var _binding: Fragment2Binding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= Fragment2Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text2 = arguments?.getString(Fragment1.TEXT)
        binding.tvfrag2.text = "Hasilnya: $text2"
        binding.btnfrag2.setOnClickListener{
            if (binding.tvfrag2.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "kolom text masih kosong", Toast.LENGTH_SHORT).show()
            } else {
                val action =
                    Fragment2Directions.actionFragment23ToFragment32(text2)
                view.findNavController().navigate(action)
            }
        }
        SendData()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun SendData(){

    }

}