package com.yudhi.notetakingapp.data

import com.yudhi.notetakingapp.model.notes

class NoteRepository(private val db: NoteDatabase) {

    fun getAll() = db.noteDao().getAllNote()

    suspend fun insert(note: notes) {
        db.noteDao().insert(note)
    }

    suspend fun update(note: notes) {
        db.noteDao().update(note)
    }

    suspend fun delete(note: notes) {
        db.noteDao().delete(note)
    }


}