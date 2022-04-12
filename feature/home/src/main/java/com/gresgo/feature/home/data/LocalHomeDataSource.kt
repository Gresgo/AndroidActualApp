package com.gresgo.feature.home.data

import com.gresgo.feature.home.data.model.GitRepoData

interface LocalHomeDataSource {
    suspend fun read(): List<GitRepoData>
    suspend fun save(repositories: List<GitRepoData>)
}