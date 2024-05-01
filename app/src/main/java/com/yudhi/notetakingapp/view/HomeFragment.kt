package com.yudhi.notetakingapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.yudhi.notetakingapp.R
import com.yudhi.notetakingapp.databinding.FragmentHomeBinding
import com.yudhi.notetakingapp.model.NotesAdapter
import com.yudhi.notetakingapp.model.notes
import com.yudhi.notetakingapp.viewmodel.NoteViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteViewModel.notesList.observe(viewLifecycleOwner, Observer { notesList ->
            // Update the RecyclerView adapter with the new list of notes
            val adapter = NotesAdapter(notesList)
            binding.recycler.adapter = adapter
        })
    }

}