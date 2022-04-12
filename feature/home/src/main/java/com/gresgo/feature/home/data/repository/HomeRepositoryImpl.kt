package com.gresgo.feature.home.data.repository

import com.gresgo.feature.home.data.LocalHomeDataSource
import com.gresgo.feature.home.data.RemoteHomeDataSource
import com.gresgo.feature.home.data.mapper.GitRepoDataMapper
import com.gresgo.feature.home.domain.GitRepoDomain
import com.gresgo.feature.home.domain.HomeRepository

class HomeRepositoryImpl(
    private val remoteDataSource: RemoteHomeDataSource,
    private val localDataSource: LocalHomeDataSource,
    private val gitRepoDataMapper: GitRepoDataMapper
): HomeRepository {
    override suspend fun fetchGitRepos(refresh: Boolean): List<GitRepoDomain> {
        if (refresh) {
            val data = remoteDataSource.fetch()
            localDataSource.save(data)
        }
        val data = localDataSource.read()
        return data.map { gitRepoDataMapper.map(it) }
    }
}