package com.example.gitmeet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmeet.R
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.AllRepository
import com.example.gitmeet.ui.adapter.ReposAdapter

class RepoActivity : AppCompatActivity() {

    private val repository by lazy { AllRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
        val listRepos = findViewById<RecyclerView>(R.id.list_repos)
        listRepos.layoutManager = LinearLayoutManager(this)
        listRepos.adapter = ReposAdapter(this, repository.getRepoList())

    }
}
