package com.gresgo.feature.home.domain

interface HomeInteractor {

    suspend fun fetchGitRepos(refresh: Boolean): HomeResult

    class Base(
        private val homeRepository: HomeRepository
    ): HomeInteractor {
        override suspend fun fetchGitRepos(refresh: Boolean): HomeResult =
            homeRepository.fetch(refresh)
    }
}