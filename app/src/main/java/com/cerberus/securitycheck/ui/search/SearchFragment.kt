package com.cerberus.securitycheck.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cerberus.securitycheck.R
import com.cerberus.securitycheck.ui.menu_bar.EmailExample
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*

const val EXTRA_MESSAGE = "com.cerberus.securitycheck.MESSAGE"

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView = inflater.inflate(R.layout.fragment_search, container, false)

        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        mView.button_search.setOnClickListener {
            val editText = editText_search
            val message = editText.text.toString()
            val intent = Intent(activity, EmailExample::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }

        // Return the fragment view/layout
        return mView

    }

}