package com.example.gitmeet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.gitmeet.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nick = findViewById<EditText>(R.id.et_nick)
        val button = findViewById<Button>(R.id.btn_user)

        nick.text
        button.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}