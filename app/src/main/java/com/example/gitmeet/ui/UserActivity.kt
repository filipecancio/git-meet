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
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, owner: Owner): Intent {
            return Intent(context, UserActivity::class.java)
                .putExtra("OWNER", owner)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val owner = intent.extras?.getSerializable("OWNER") as Owner

        Glide.with(this).load(owner.avatarUrl).into(findViewById(R.id.user_avatar))
        findViewById<TextView>(R.id.user_name).text = owner.name
        findViewById<TextView>(R.id.user_nick).text = owner.login
        //findViewById<TextView>(R.id.user_pro).text = owner.plan.name
        findViewById<TextView>(R.id.user_status).text = owner.login
        findViewById<TextView>(R.id.user_desc).text = owner.bio

        val button = findViewById<Button>(R.id.btn_repos)
        button.setOnClickListener {
            startActivity(Intent(this, RepoListActivity::class.java).putExtra("OWNER", owner.login))
        }
    }

    private fun onError() {
        Toast.makeText(this, "vixe, deu erro!", Toast.LENGTH_SHORT).show()
    }

}