package com.yudhi.notetakingapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yudhi.notetakingapp.model.notes

@Dao
interface NoteDao {
    @Insert
    fun insert(note: notes)
    @Update
    suspend fun update(note: notes)

    @Delete
    suspend fun delete(note: notes)


    @Query("SELECT * FROM note_table ORDER BY noteId DESC")
    fun getAllNote(): LiveData<List<notes>>
}
