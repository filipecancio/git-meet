package com.example.gitmeet.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.gitmeet.R
import com.example.gitmeet.model.User
import com.example.gitmeet.repository.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private val repository by lazy { GithubRepository() }

    companion object {
        fun getStartIntent(context: Context, owner: String): Intent {
            return Intent(context, UserActivity::class.java)
                .putExtra("OWNER", owner)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val nick = intent.extras?.getSerializable("OWNER") as String

        repository.getOwner(nick).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val owner = response.body()
                    Glide.with(this@UserActivity).load(owner?.avatarUrl).into(findViewById(R.id.user_avatar))
                    findViewById<TextView>(R.id.user_name).text = owner?.name
                    findViewById<TextView>(R.id.user_nick).text = owner?.login
                    findViewById<TextView>(R.id.user_status).text = owner?.login
                    findViewById<TextView>(R.id.user_desc).text = owner?.bio

                    val button = findViewById<Button>(R.id.btn_repos)
                    button.setOnClickListener {
                        startActivity(Intent(this@UserActivity, RepoListActivity::class.java).putExtra("OWNER", owner?.login))
                    }
                } else {
                    onError()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                onError()
            }
        })


    }

    private fun onError() {
        Toast.makeText(this, "vixe, deu erro!", Toast.LENGTH_SHORT).show()
    }

}