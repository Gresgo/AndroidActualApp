package com.gresgo.feature.home.domain

interface HomeRepository {
    suspend fun fetchGitRepos(refresh: Boolean): List<GitRepoDomain>
}