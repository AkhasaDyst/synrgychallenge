package com.yudhi.notetakingapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yudhi.notetakingapp.R
import com.yudhi.notetakingapp.databinding.FragmentDeleteNoteBinding
import com.yudhi.notetakingapp.databinding.FragmentHomeBinding

class DeleteNoteFragment : Fragment() {
    private lateinit var binding: FragmentDeleteNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDeleteNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}