package com.gresgo.feature.home.data

import com.gresgo.feature.home.data.dao.GitRepoDao
import com.gresgo.feature.home.data.mapper.GitRepoLocalMapper
import com.gresgo.feature.home.data.model.GitRepoData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

interface LocalHomeDataSource {
    suspend fun read(): List<GitRepoData>
    suspend fun save(repositories: List<GitRepoData>)
    fun observe(): Flow<List<GitRepoData>>

    class Base(
        private val dao: GitRepoDao,
        private val mapper: GitRepoLocalMapper
    ): LocalHomeDataSource {

        override suspend fun read(): List<GitRepoData> =
            dao.queryAll().map { mapper.map(it) }

        override suspend fun save(repositories: List<GitRepoData>) =
            dao.insertAll(repositories.map { mapper.map(it) })

        override fun observe(): Flow<List<GitRepoData>> = flow {

        }

    }
}