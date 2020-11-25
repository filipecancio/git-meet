package com.example.gitmeet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gitmeet.R
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.GithubRepository
import com.example.gitmeet.ui.RepoDetailActivity.Companion.getStartIntent
import com.example.gitmeet.ui.adapter.ReposAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repository by lazy { GithubRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nick = findViewById<EditText>(R.id.et_nick).text.toString()
        val button = findViewById<Button>(R.id.btn_user)

        button.setOnClickListener {
            this.repository.getOwner("diego3g").enqueue(object : Callback<Owner> {
                override fun onResponse(call: Call<Owner>, response: Response<Owner>) {
                    if (response.isSuccessful) {
                        this@MainActivity.startActivity(
                            UserActivity.getStartIntent(
                                this@MainActivity,
                                response.body()!!
                            )
                        )
                    } else {
                        onError()
                    }

                }

                override fun onFailure(call: Call<Owner>, t: Throwable) {
                    onError()
                }
            })
        }

    }

    private fun onError() {
        Toast.makeText(this, "vixe, deu erro!", Toast.LENGTH_SHORT).show()
    }
}