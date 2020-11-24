package com.example.gitmeet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmeet.R
import com.example.gitmeet.repository.AllRepository
import com.example.gitmeet.ui.adapter.CommitsAdapter

class AboutRepoActivit : AppCompatActivity() {
    private val repository by lazy { AllRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_repo)
        findViewById<RecyclerView>(R.id.list_commits).adapter = CommitsAdapter(this, repository.getCommitList())
    }

}