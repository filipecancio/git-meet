package com.example.gitmeet.model

import com.google.gson.annotations.SerializedName

class Commit(
    @SerializedName("sha")
    val hash: String,
    @SerializedName("author")
    val owner: Owner,
    @SerializedName("commit")
    val detail: Detail
)

class Detail(
    val message: String
)