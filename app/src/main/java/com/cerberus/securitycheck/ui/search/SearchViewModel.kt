package com.cerberus.securitycheck.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "*WIP* Data Breach Check Tool"
    }
    val text: LiveData<String> = _text
}