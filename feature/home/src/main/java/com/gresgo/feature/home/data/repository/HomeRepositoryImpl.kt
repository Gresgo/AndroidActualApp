package com.gresgo.feature.home.data.repository

import com.gresgo.feature.home.data.LocalHomeDataSource
import com.gresgo.feature.home.data.RemoteHomeDataSource
import com.gresgo.feature.home.data.mapper.GitRepoDataMapper
import com.gresgo.feature.home.domain.GitRepoDomain
import com.gresgo.feature.home.domain.HomeRepository
import com.gresgo.feature.home.domain.HomeResult
import kotlinx.coroutines.flow.flow

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

    override suspend fun fetch(refresh: Boolean): HomeResult {
        var error: Throwable? = null
        if (refresh) {
            try {
                val data = remoteDataSource.fetch()
                localDataSource.save(data)
            } catch (e: Exception) {
                error = e
            }
        }
        val data = localDataSource.read().map { gitRepoDataMapper.map(it) }
        return error
            ?.let {
                HomeResult.Failure(data, it)
            }
            ?: run {
                HomeResult.Success(data)
            }
    }
}