package com.cerberus.securitycheck

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cerberus.securitycheck.ui.menu_bar.AboutActivity
import com.cerberus.securitycheck.ui.menu_bar.FaqActivity
import com.cerberus.securitycheck.ui.menu_bar.FeedbackActivity
import com.cerberus.securitycheck.ui.menu_bar.PrivacyActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            textViewResult = findViewById(R.id.text_view_result)

            val retrofit = Retrofit.Builder()
                .baseUrl("https://haveibeenpwned.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val breachApi: BreachApi = retrofit.create(BreachApi::class.java)
            val call: Call<List<Breaches>> = breachApi.getBreaches()


            call.enqueue(object : Callback<List<Breaches>> {
                override fun onResponse(
                    call: Call<List<Breaches>>,
                    response: Response<List<Breaches>>
                ) {
                    if (!response.isSuccessful) {
                        textViewResult.text = "Code: " + response.code()
                        return
                    }
                    val allbreaches: List<Breaches>? = response.body()

                    for (breach in allbreaches!!) {
                        var content = ""
                        content += "Name: " + breach.Name + "\n"
                        content += "Title: " + breach.Title + "\n"
                        content += "Domain: " + breach.Domain + "\n"
                        content += "BreachDate: " + breach.BreachDate + "\n"
                        content += "PwnCount: " + breach.PwnCount + "\n"
                        content += "Description: " + breach.Description + "\n"
                        content += "LogoPath: " + breach.LogoPath + "\n"
                        textViewResult.append(content)
                    }
                }

                // Means something went wrong when communicating with server
                //    or processing response
                override fun onFailure(
                    call: Call<List<Breaches>>,
                    t: Throwable
                ) {
                    textViewResult.text = t.message
                }

            })


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