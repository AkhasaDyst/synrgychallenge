package com.yudhi.synrgychall3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.yudhi.synrgychall3.databinding.Fragment1Binding
import com.yudhi.synrgychall3.databinding.Fragment3Binding

class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding?=null
    private val binding get() = _binding!!
    companion object{
        var TEXT = "TEXT"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= Fragment1Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SendData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun SendData(){
        binding.btnfrag1.setOnClickListener{
            var etText = binding.etfrag1.getText().toString()

            val bundle = Bundle()
            bundle.putString(TEXT, etText)
            it.findNavController().navigate(R.id.action_fragment12_to_fragment23, bundle)

        }
    }
}