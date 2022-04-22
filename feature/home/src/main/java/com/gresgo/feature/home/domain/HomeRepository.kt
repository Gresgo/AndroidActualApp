package com.gresgo.feature.home.domain

interface HomeRepository {
//    suspend fun observeGitRepos(refresh: Boolean): Flow<List<GitRepoDomain>>
    suspend fun fetchGitRepos(refresh: Boolean): List<GitRepoDomain>

    suspend fun fetch(refresh: Boolean): HomeResult
}