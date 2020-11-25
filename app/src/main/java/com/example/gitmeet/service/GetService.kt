package com.example.gitmeet.service

import com.example.gitmeet.model.Commit
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo
import retrofit2.Call
import retrofit2.http.*

interface GetService {

    @GET("users/{owner}")
    fun getOwner(@Path("owner") owner: String): Call<Owner>

    @GET("users/filipecancio/repos")
    fun getRepoList(): Call<List<Repo>>

    @GET("repos/filipecancio/{repo}/commits")
    fun getCommitList(@Path("repo") repo: String): Call<List<Commit>>
}