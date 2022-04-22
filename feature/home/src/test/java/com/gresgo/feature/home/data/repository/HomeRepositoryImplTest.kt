package com.gresgo.feature.home.data.repository

import com.gresgo.feature.home.data.LocalHomeDataSource
import com.gresgo.feature.home.data.RemoteHomeDataSource
import com.gresgo.feature.home.data.mapper.GitRepoDataMapper
import com.gresgo.feature.home.data.model.GitRepoData
import com.gresgo.feature.home.domain.GitRepoDomain
import com.gresgo.feature.home.domain.HomeResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

// HERE
// if fetch result is success ->                    return Success(data)
// if fetch result is failure and data is ok ->     return Failure(data, error)
// if fetch result is failure and data is empty ->  return Failure(data, error)

// IN ViewMODEL
// if result is success ->                          State.Content
// if result is success and data is empty ->        State.Empty
// if result is failure and data is ok ->           State.Content and show snack ???
// if result is failure and data is empty ->        State.Error

class HomeRepositoryImplTest {

    @Test
    fun test_all_success() {
        val repo = HomeRepositoryImpl(successRemoteDataSource, successLocalDataSource, mapper)
        runBlocking {
            val actual = repo.fetch(true)
            assert(actual is HomeResult.Success)
            val success = (actual as HomeResult.Success)
            assert(success.data.isNotEmpty())
        }
    }

    @Test
    fun test_all_empty() {
        val repo = HomeRepositoryImpl(emptyRemoteDataSource, emptyLocalDataSource, mapper)
        runBlocking {
            val actual = repo.fetch(true)
            assert(actual is HomeResult.Success)
            val success = (actual as HomeResult.Success)
            assert(success.data.isEmpty())
        }
    }

    @Test
    fun test_error() {
        val repo = HomeRepositoryImpl(errorRemoteDataSource, successLocalDataSource, mapper)
        runBlocking {
            val actual = repo.fetch(true)
            assert(actual is HomeResult.Failure)
            val failure = (actual as HomeResult.Failure)
            assertNotNull(failure.error)
            assert(failure.data.isNotEmpty())
        }
    }

    private val mapper = GitRepoDataMapper.Base()
    private val testData = GitRepoData(1, 1, "", "", "", "", 1, 1, listOf())
    private val expectedData = listOf(GitRepoDomain(1, 1, "", "", "", "", 1, 1, listOf()))

    private val successLocalDataSource = object : LocalHomeDataSource {
        override fun observe(): Flow<List<GitRepoData>> = flow {}
        override suspend fun read(): List<GitRepoData> = listOf(testData)
        override suspend fun save(repositories: List<GitRepoData>) {}
    }

    private val successRemoteDataSource = object : RemoteHomeDataSource {
        override suspend fun fetch(): List<GitRepoData> = listOf(testData)
    }

    private val emptyLocalDataSource = object : LocalHomeDataSource {
        override fun observe(): Flow<List<GitRepoData>> = flow {}
        override suspend fun read(): List<GitRepoData> = emptyList()
        override suspend fun save(repositories: List<GitRepoData>) {}
    }

    private val emptyRemoteDataSource = object : RemoteHomeDataSource {
        override suspend fun fetch(): List<GitRepoData> = emptyList()
    }

    private val errorRemoteDataSource = object : RemoteHomeDataSource {
        override suspend fun fetch(): List<GitRepoData> = throw Exception("fetch failed")
    }
}