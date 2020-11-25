package com.example.gitmeet.repository

import android.text.Editable
import com.example.gitmeet.model.Commit
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import com.example.gitmeet.service.GetService
import retrofit2.Call


class GithubRepository {

    fun getOwner(owner: String):Call<Owner>{
        return RetrofitClient.createService(GetService::class.java).getOwner(owner)
    }

    fun getRepoListAsync(owner: String): Call<List<Repo>> {
        return RetrofitClient.createService(GetService::class.java).getRepoList(owner)
    }

    fun getCommitListAsync(owner: String,repo: String): Call<List<Commit>> {
        return RetrofitClient.createService(GetService::class.java).getCommitList(owner,repo)
    }

}