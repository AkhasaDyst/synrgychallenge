package com.yudhi.notetakingapp.model

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.FileObserver.DELETE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Delete
import com.yudhi.notetakingapp.R
import com.yudhi.notetakingapp.data.NoteDatabase
import com.yudhi.notetakingapp.data.NoteRepository
import com.yudhi.notetakingapp.view.HomeFragment
import com.yudhi.notetakingapp.viewmodel.NoteViewModel
import com.yudhi.notetakingapp.viewmodel.NoteViewModelFactory

class NotesAdapter (private var notesList: List<notes>, private val listener: HomeFragment)
    : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View, private val listener: HomeFragment) : RecyclerView.ViewHolder(itemView) {
        val judulNotes: TextView = itemView.findViewById(R.id.tv_judul)
        val ringkasanNotes: TextView = itemView.findViewById(R.id.tv_ringkasan)
        val editNotes: Button = itemView.findViewById(R.id.btn_edit)
        val deleteNotes: Button = itemView.findViewById(R.id.btn_delete)
        fun bind(notes: notes) {
            judulNotes.text = notes.noteTitle
            ringkasanNotes.text = notes.noteContent

            editNotes.setOnClickListener {
                listener.onEditClicked(notes)
            }

            deleteNotes.setOnClickListener {
                listener.onDeleteClicked(notes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_note, parent, false)
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notesList[position])
    }


}