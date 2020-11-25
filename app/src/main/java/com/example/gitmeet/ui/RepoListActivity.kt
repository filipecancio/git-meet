package com.example.gitmeet.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmeet.R
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.GithubRepository
import com.example.gitmeet.ui.adapter.ReposAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListActivity : AppCompatActivity() {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.list_repos) }

    private val repository by lazy { GithubRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        val owner = intent.extras?.getSerializable("OWNER") as String

        repository.getRepoListAsync(owner).enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                if (response.isSuccessful) {
                    recyclerView.adapter = ReposAdapter(this@RepoListActivity, response.body()!!)
                } else {
                    onError()
                }

            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                onError()
            }
        })

    }

    private fun onError() {
        Toast.makeText(this, "vixe, deu erro!", Toast.LENGTH_SHORT).show()
    }
}
