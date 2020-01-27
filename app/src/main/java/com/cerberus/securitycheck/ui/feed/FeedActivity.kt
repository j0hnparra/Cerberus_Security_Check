package com.cerberus.securitycheck.ui.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cerberus.securitycheck.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_feed.*
import okhttp3.*
import java.io.IOException

class FeedActivity : AppCompatActivity(){

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_feed)

    recyclerView_feed.layoutManager = LinearLayoutManager(this)
    //recyclerView_feed.adapter = FeedAdapter()

    fetchJson()

    }

    fun fetchJson(){
        println("Attempting to fetch JSON")

        val url = "https://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=2c5b37ed2d264c4eaed11838676ca66a"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_feed.adapter = FeedAdapter(homeFeed)
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

        })
    }

}

class HomeFeed(val articles: List<Article>)

class Source(val name: String)

class Article(val author: String, val title: String, val description: String, val url: String, val urlToImage: String)
