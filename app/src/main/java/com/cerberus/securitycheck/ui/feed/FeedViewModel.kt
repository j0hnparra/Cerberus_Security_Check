package com.cerberus.securitycheck.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//Glue between VIEW and Business logic
//Direct reference repository -> Local Data Source Model or Remote Data Source Model

class FeedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "NEWS FEED"
    }
    val text: LiveData<String> = _text
}