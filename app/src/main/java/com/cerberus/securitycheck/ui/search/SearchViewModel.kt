package com.cerberus.securitycheck.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


//Glue between VIEW and Business logic
    //Direct reference repository -> Local Data Source Model or Remote Data Source Model

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "About us and the application...."
    }
    val text: LiveData<String> = _text

}