package com.yudhi.notetakingapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yudhi.notetakingapp.data.NoteRepository
import com.yudhi.notetakingapp.data.dao.NoteDao
import com.yudhi.notetakingapp.model.notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (val noteRepository: NoteRepository): ViewModel() {

    fun getAll(): LiveData<List<notes>> = noteRepository.getAll()

    fun insert(note: notes) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.insert(note)
    }

    fun delete(note: notes) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.delete(note)
    }

    fun update(note: notes) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.update(note)
    }
}