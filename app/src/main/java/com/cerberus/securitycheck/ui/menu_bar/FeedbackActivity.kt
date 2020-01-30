package com.cerberus.securitycheck.ui.menu_bar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.cerberus.securitycheck.R

class FeedbackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_about -> {
                this.startActivity(Intent(this, AboutActivity::class.java))
                return true
            }
            R.id.action_faq -> {
                this.startActivity(Intent(this, FaqActivity::class.java))
                return true
            }
            R.id.action_feedback -> {
                this.startActivity(Intent(this, FeedbackActivity::class.java))
                return true
            }
            R.id.action_privacy -> {
                this.startActivity(Intent(this, PrivacyActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
