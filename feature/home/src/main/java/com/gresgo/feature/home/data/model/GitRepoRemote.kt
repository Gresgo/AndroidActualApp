package com.gresgo.feature.home.data.model

data class GitRepoRemote(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: GitRepoOwner,
    val url: String,
    val description: String,
    val language: String,
    val starsCount: Int,
    val watchersCount: Int,
    val topics: List<String>
)

data class GitRepoOwner(
    val id: Int,
    val login: String,
    val url: String,
    val reposUrl: String,

)