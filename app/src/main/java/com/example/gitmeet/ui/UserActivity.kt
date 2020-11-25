package com.example.gitmeet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.gitmeet.R
import com.example.gitmeet.model.Commit
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.GithubRepository
import com.example.gitmeet.ui.adapter.ReposAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private val repository by lazy { GithubRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        repository.getOwner("diego3g").enqueue(object : Callback<Owner> {
            override fun onResponse(call: Call<Owner>, response: Response<Owner>) {
                if (response.isSuccessful) {
                    val owner = response.body()
                    Glide.with(this@UserActivity).load(owner?.avatarUrl).into(findViewById(R.id.user_avatar))
                    findViewById<TextView>(R.id.user_name).text = owner?.name
                    findViewById<TextView>(R.id.user_nick).text = owner?.login
                    //findViewById<TextView>(R.id.user_pro).text = owner?.login
                    //findViewById<TextView>(R.id.user_status).text = owner?.login
                    findViewById<TextView>(R.id.user_desc).text = owner?.bio


                } else {
                    onError()
                }
            }
            override fun onFailure(call: Call<Owner>, t: Throwable) {
                onError()
            }
        })





        val button = findViewById<Button>(R.id.btn_repos)
        button.setOnClickListener {
            startActivity(Intent(this, RepoListActivity::class.java))
        }
    }

    private fun onError() {
        Toast.makeText(this, "vixe, deu erro!", Toast.LENGTH_SHORT).show()
    }

}