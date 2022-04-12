package com.gresgo.feature.home.data.model

data class GitRepoData(
    val id: Int,
    val ownerId: Int,
    val name: String,
    val owner: String,
    val description: String,
    val language: String,
    val starsCount: Int,
    val watchersCount: Int,
    val topics: List<String>
)