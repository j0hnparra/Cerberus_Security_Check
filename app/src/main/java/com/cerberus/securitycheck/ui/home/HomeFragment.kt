package com.cerberus.securitycheck.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cerberus.securitycheck.R
import com.cerberus.securitycheck.ui.menu_bar.FaqActivity
import com.cerberus.securitycheck.ui.menu_bar.FeedbackActivity
import com.cerberus.securitycheck.ui.notifications.NotificationsView
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var mView: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        mView.faq_button.setOnClickListener {
            val intent = Intent(activity, FaqActivity::class.java)
            startActivity(intent)
        }

        mView.contact_button.setOnClickListener {
            val intent = Intent(activity, FeedbackActivity::class.java)
            startActivity(intent)
        }

        // Return the fragment view/layout
        return mView
    }
}