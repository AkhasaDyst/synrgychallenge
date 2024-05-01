package com.yudhi.notetakingapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class notes(
    @PrimaryKey(autoGenerate = true)
    val noteId: Long? = null,

    @ColumnInfo(name = "note_title")
    val noteTitle: String? = null,

    @ColumnInfo(name = "note_content")
    val noteContent: String? = null
)
