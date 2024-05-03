package com.yudhi.notetakingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yudhi.notetakingapp.data.NoteRepository

class NoteViewModelFactory (private val noteRepository: NoteRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteRepository) as T
    }
}