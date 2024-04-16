package com.yudhi.synrgychall2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yudhi.synrgychall2.databinding.FragmentTotalBinding

class TotalFragment : Fragment() {
    private lateinit var binding: FragmentTotalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTotalBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveData()
    }

    private fun retrieveData(withKey:String="BUNDLE_TOTAL"){
        val result = arguments?.getInt(withKey)
        binding.tvtotal.text = result.toString()
    }
}