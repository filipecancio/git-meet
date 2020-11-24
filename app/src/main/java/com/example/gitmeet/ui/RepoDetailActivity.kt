package com.example.gitmeet.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmeet.R
import com.example.gitmeet.model.Commit
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.GithubRepository
import com.example.gitmeet.ui.adapter.CommitsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoDetailActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.list_commits) }
    private val txtRepoName by lazy { findViewById<TextView>(R.id.txt_repo_name) }
    private val txtIssues by lazy { findViewById<TextView>(R.id.txt_issues) }
    private val txtCommitCount by lazy { findViewById<TextView>(R.id.txt_commit_count) }

    private val repository by lazy { GithubRepository() }

    companion object {
        fun getStartIntent(context: Context, repo: Repo): Intent {
            return Intent(context, RepoDetailActivity::class.java)
                .putExtra("REPOSITORY", repo)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_detail)

        val repo = intent.extras?.getSerializable("REPOSITORY") as Repo

        txtRepoName.text = repo.name
        txtIssues.text = "${repo.openIssuesCount} Issues"

        repository.getCommitListAsync(repo.name).enqueue(object : Callback<List<Commit>> {
            override fun onResponse(call: Call<List<Commit>>, response: Response<List<Commit>>) {
                if (response.isSuccessful) {
                    val body = response.body()!!
                    txtCommitCount.text = "${body.size} Commits"
                    recyclerView.adapter = CommitsAdapter(this@RepoDetailActivity, body)
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<List<Commit>>, t: Throwable) {
                onError()
            }
        })
    }

    fun onError() {
        Toast.makeText(this, "Deu Erro", Toast.LENGTH_SHORT).show()
    }

}