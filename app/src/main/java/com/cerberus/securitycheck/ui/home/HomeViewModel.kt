package com.cerberus.securitycheck.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "All Breaches via HaveIBeenPwned"
    }
    val text: LiveData<String> = _text
}