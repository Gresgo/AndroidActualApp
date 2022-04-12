package com.gresgo.feature.home.data.model

data class GitRepoLocal(
    val id: Int,
    val ownerId: Int,
    val name: String,
    val owner: String,
    val description: String,
    val language: String,
    val starsCount: String,
    val watchersCount: String,
    val topics: List<String>
)