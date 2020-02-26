package com.cerberus.securitycheck.ui.search

import com.cerberus.securitycheck.repository.BreachApi
import com.cerberus.securitycheck.models.Breaches
import com.cerberus.securitycheck.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmailResult : AppCompatActivity() {

    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_result)

        textViewResult = findViewById(R.id.text_view_result)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://haveibeenpwned.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val breachApi: BreachApi = retrofit.create(BreachApi::class.java)

        val call: Call<List<Breaches>> = breachApi.getBreaches("$message")

        call.enqueue(object : Callback<List<Breaches>> {
            override fun onResponse(
                call: Call<List<Breaches>>,
                response: Response<List<Breaches>>
            ) {
                if (!response.isSuccessful) {
                    textViewResult.text =
                        "Code: " + response.code() + "\nNot found — the account could not be found and has therefore not been pwned"
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
                    content += "LogoPath: " + breach.LogoPath + "\n\n"
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
    }
}