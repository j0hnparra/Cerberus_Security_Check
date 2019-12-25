package com.cerberus.securitycheck.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "*WIP* Subscribe to notifications of any future data leaks."
    }
    val text: LiveData<String> = _text
}