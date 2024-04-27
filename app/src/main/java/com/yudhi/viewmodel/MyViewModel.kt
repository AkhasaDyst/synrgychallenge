package com.yudhi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {

    private val _users: MutableLiveData<UserA> by lazy {
        MutableLiveData<UserA>()
    }
    val users: LiveData<UserA>
        get() = _users

    var point = 0

    val _points: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0 // Set initial value
        }
    }
    val points: LiveData<Int>
        get() = _points

    private val _teams: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            value = "Chicago" // Set initial value
        }
    }
    val teams: LiveData<String>
        get() = _teams
}