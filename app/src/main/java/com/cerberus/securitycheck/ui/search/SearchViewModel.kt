package com.cerberus.securitycheck.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Check to see if your data has been stolen by using our Security Check tool, which will check your credentials against a database of previously breached data"
    }
    val text: LiveData<String> = _text
}