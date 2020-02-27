package com.cerberus.securitycheck

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cerberus.securitycheck.ui.menu_bar.*
import com.cerberus.securitycheck.ui.search.EmailResult
import com.cerberus.securitycheck.ui.search.PasteResult
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_search,
                R.id.navigation_feed,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
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