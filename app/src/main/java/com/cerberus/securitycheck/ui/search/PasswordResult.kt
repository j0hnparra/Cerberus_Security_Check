package com.cerberus.securitycheck.ui.search

import com.cerberus.securitycheck.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cerberus.securitycheck.repository.PasteApi
import com.cerberus.securitycheck.models.Pastes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PasswordResult : AppCompatActivity() {

    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_result)

        textViewResult = findViewById(R.id.text_view_result)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://haveibeenpwned.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pasteApi: PasteApi = retrofit.create(
            PasteApi::class.java)
        val call: Call<List<Pastes>> = pasteApi.getPastes("bob@gmail.com")

        call.enqueue(object : Callback<List<Pastes>> {
            override fun onResponse(
                call: Call<List<Pastes>>,
                response: Response<List<Pastes>>
            ) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code() + "\nNot found — the account could not be found and has therefore not been pwned"
                    return
                }
                val allpastes: List<Pastes>? = response.body()

                for (paste in allpastes!!) {
                    var content = ""
                    content += "Source: " + paste.Source + "\n"
                    content += "Id: " + paste.Id + "\n"
                    content += "Title: " + paste.Title + "\n"
                    content += "EmailCount: " + paste.EmailCount + "\n"

                    textViewResult.append(content)
                }
            }

            // Means something went wrong when communicating with server
            //    or processing response
            override fun onFailure(
                call: Call<List<Pastes>>,
                t: Throwable
            ) {
                textViewResult.text = t.message
            }

        })
    }
}