package com.cerberus.securitycheck.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cerberus.securitycheck.R
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView = inflater.inflate(R.layout.fragment_notifications, container, false)

        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        mView.button_alerts.setOnClickListener {
            val intent = Intent(activity, NotificationsView::class.java)
            startActivity(intent)
        }

        // Return the fragment view/layout
        return mView

    }
}