package com.cerberus.securitycheck.ui.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cerberus.securitycheck.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_feed.*
import okhttp3.*
import java.io.IOException

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_feed)
    }
}


