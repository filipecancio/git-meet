package com.example.gitmeet.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Repo(
    val id: String,
    val name: String,
    val owner: Owner,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int,
    val description: String
) : Serializable