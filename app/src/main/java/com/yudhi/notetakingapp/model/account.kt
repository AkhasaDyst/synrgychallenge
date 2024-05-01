package com.yudhi.notetakingapp.model

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "user_table")
data class account(
    @PrimaryKey(autoGenerate = true)
    val userId: Long? = null,

    @ColumnInfo(name = "user_name")
    val userAcc: String? = null,

    @ColumnInfo(name = "user_pass")
    val passAcc: String? = null,

    @ColumnInfo(name = "user_email")
    val emailAcc: Email? = null
)
