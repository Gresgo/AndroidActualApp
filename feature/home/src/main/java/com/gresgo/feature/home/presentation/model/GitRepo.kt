package com.gresgo.feature.home.presentation.model

data class GitRepo(
    val name: String,
    val description: String,
    val author: String,
    val stars: Int,
    val language: String
)