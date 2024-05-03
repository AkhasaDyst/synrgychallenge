package com.yudhi.notetakingapp.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yudhi.notetakingapp.R
import com.yudhi.notetakingapp.data.NoteDatabase
import com.yudhi.notetakingapp.data.NoteRepository
import com.yudhi.notetakingapp.databinding.FragmentHomeBinding
import com.yudhi.notetakingapp.model.NotesAdapter
import com.yudhi.notetakingapp.model.SharedPreference
import com.yudhi.notetakingapp.model.notes
import com.yudhi.notetakingapp.viewmodel.NoteViewModel
import com.yudhi.notetakingapp.viewmodel.NoteViewModelFactory


class HomeFragment : Fragment() {
    private lateinit var noteViewModel:NoteViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var noteAdapter: NotesAdapter

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
        setupViewModel()
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        noteViewModel.getAll().observe(viewLifecycleOwner, Observer { notesList ->
            val adapter = NotesAdapter(notesList, this)
            recyclerView.adapter = adapter
        })

        binding.btnAdd.setOnClickListener{
            onAddClicked(notes())
        }

        binding.tvLogout.setOnClickListener{
            //SharedPreference.clearAccount(requireContext())
            view.findNavController().navigateUp()
        }
        val username = SharedPreference.getSavedAccount(requireContext()).first
        binding.tvWelcome.text = "Welcome, $username"


    }

    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase.getInstance(requireContext()))
        val viewModelFactory = NoteViewModelFactory(noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)
    }
    fun onEditClicked(note: notes) {
        val noteId = note.noteId
        var noteTittle = note.noteTitle
        val noteContent = note.noteContent

        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_edit_note)
        dialog.findViewById<TextView>(R.id.tv_edit).text = "Edit Note"
        dialog.findViewById<EditText>(R.id.et_judul).setText(noteTittle)
        dialog.findViewById<EditText>(R.id.et_notes).setText(noteContent)
        dialog.findViewById<Button>(R.id.btn_edit).setOnClickListener {
            val newTittle = dialog.findViewById<EditText>(R.id.et_judul).text.toString()
            val newNotes = dialog.findViewById<EditText>(R.id.et_notes).text.toString()
            Toast.makeText(requireContext(), "EDITED", Toast.LENGTH_LONG).show()
            noteViewModel.update(notes(noteId, newTittle, newNotes))
            dialog.dismiss()
        }

        dialog.show()
    }

    fun onDeleteClicked(note: notes) {
        val noteId = note.noteId
        val noteTittle = note.noteTitle
        val noteContent = note.noteContent

        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_delete_note)
        dialog.findViewById<TextView>(R.id.tv_delete).text = "Delete Note"
        dialog.findViewById<Button>(R.id.btn_delete).setOnClickListener {
            Toast.makeText(requireContext(), "DELETED", Toast.LENGTH_LONG).show()
            noteViewModel.delete(notes(noteId, noteTittle, noteContent))
            dialog.dismiss()
        }
        dialog.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun onAddClicked(note: notes) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_add_note)
        dialog.findViewById<TextView>(R.id.tv_input).text = "Input Note"

        val noteTittle = dialog.findViewById<EditText>(R.id.et_judul).text
        val noteContent = dialog.findViewById<EditText>(R.id.et_notes).text

        dialog.findViewById<Button>(R.id.btn_input).setOnClickListener {
            if (noteTittle.isNullOrEmpty() || noteContent.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                noteViewModel.insert(notes(null, noteTittle.toString(), noteContent.toString()))
                Toast.makeText(requireContext(), "NOTE ADDED", Toast.LENGTH_LONG).show()
            }
            dialog.dismiss()
        }
        dialog.show()
    }



}