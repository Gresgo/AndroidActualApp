package com.gresgo.feature.home.data

import com.gresgo.feature.home.data.model.GitRepoData

interface RemoteHomeDataSource {
    suspend fun fetch(): List<GitRepoData>

    class Base: RemoteHomeDataSource {
        override suspend fun fetch(): List<GitRepoData> {
            return emptyList()
        }
    }
}