package com.cerberus.securitycheck.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cerberus.securitycheck.R
import kotlinx.android.synthetic.main.feed_row.view.*

class FeedAdapter(private val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val articleTitles = listOf("First title", "Second Title")

    //numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.articles.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // Creates a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.feed_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val articleTitle = articleTitles.get(position)

        val article = homeFeed.articles.get(position)
        holder.view.textView_article_title.text = article.title
        holder.view.textView_article_title.text = article.author
        holder.view.textView_article_title.text = article.url

    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}