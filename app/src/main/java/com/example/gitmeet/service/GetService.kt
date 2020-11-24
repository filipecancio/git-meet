package com.example.gitmeet.service

import com.example.gitmeet.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GetService {
    @GET("users/filipecancio/repos")
    fun getRepoList(): Call<List<Repo>>
}