package com.cerberus.securitycheck.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "*WIP* Cerberus Security Check is a tool that allows you to check if your credentials have been exposed on the Internet."
    }
    val text: LiveData<String> = _text
}