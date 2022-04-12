package com.gresgo.feature.home.domain

interface HomeInteractor {

    suspend fun fetchGitRepos(refresh: Boolean): List<GitRepoDomain>

    class Base(
        private val homeRepository: HomeRepository
    ): HomeInteractor {
        override suspend fun fetchGitRepos(refresh: Boolean): List<GitRepoDomain> {
            return homeRepository.fetchGitRepos(refresh)
        }
    }
}