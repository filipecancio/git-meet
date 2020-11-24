package com.example.gitmeet.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmeet.R
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.repository.AllRepository
import com.example.gitmeet.ui.adapter.ReposAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoActivity : AppCompatActivity() {

    private val repository by lazy { AllRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
        val listRepos = findViewById<RecyclerView>(R.id.list_repos)
        listRepos.layoutManager = LinearLayoutManager(this)
        repository.getRepoListAsync().enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                if(response.isSuccessful){
                    val list = response.body()
                    listRepos.adapter = ReposAdapter(this@RepoActivity, list!!)
                }else{
                    Toast.makeText(this@RepoActivity,"vixe, deu erro!",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Toast.makeText(this@RepoActivity,"vixe, nem carregou isso aqui!",Toast.LENGTH_SHORT).show()
            }
        })

    }
}
