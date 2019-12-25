package com.cerberus.securitycheck.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "*WIP* News Feed"
    }
    val text: LiveData<String> = _text
}