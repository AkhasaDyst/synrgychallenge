package com.yudhi.notetakingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudhi.notetakingapp.model.notes

class AccountViewModel():ViewModel() {
    private val _account: MutableLiveData<notes> = MutableLiveData(emptyList())
    val account get() = _account
}