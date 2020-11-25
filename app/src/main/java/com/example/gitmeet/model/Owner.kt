package com.example.gitmeet.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Owner(
    val id: String,
    val login: String,
    val name: String,
    val bio: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
) : Serializable