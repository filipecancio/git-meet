package com.example.gitmeet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gitmeet.R
import com.example.gitmeet.repository.GithubRepository

class MainActivity : AppCompatActivity() {

    private val repository by lazy { GithubRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nick = findViewById<EditText>(R.id.et_nick)
        val button = findViewById<Button>(R.id.btn_user)

        button.setOnClickListener {
            this.startActivity(
                UserActivity.getStartIntent(this, nick.text.toString())
            )
        }

    }
}