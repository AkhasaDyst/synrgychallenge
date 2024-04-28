package com.yudhi.notetakingapp.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class account(
    val userAcc: String,
    val passAcc: String,
    val emailAcc: Email
)
