package com.gresgo.feature.home.domain

data class GitRepoDomain(
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