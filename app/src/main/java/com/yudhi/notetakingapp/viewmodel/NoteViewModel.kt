package com.yudhi.notetakingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudhi.notetakingapp.model.notes

class NoteViewModel (): ViewModel() {
    private val _notes: MutableLiveData<List<notes>> = MutableLiveData(emptyList())
    val notes get() = _notes

    fun addNote(note: notes) {
        val existingNotes = _notes.value
        val listNote = mutableListOf<notes>()
        if (existingNotes?.isEmpty() == true) {
            listNote.add(note)
        } else {
            listNote.addAll(existingNotes as List<notes>)
            listNote.add(note)
        }
        _notes.value = listNote
    }

    fun deleteNote(idNote: String) {
        val listNote = mutableListOf<notes>()
        val dataNote = _notes.value
        dataNote?.forEach {
            if (it.noteId != idNote) {
                listNote.add(it)
            }
        }
        _notes.value = listNote
    }

}