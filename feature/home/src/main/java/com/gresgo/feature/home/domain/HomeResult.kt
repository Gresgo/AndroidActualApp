package com.gresgo.feature.home.domain

sealed interface HomeResult {
    data class Success(val data: List<GitRepoDomain>) : HomeResult
    data class Failure(val data: List<GitRepoDomain>, val error: Throwable) : HomeResult
}

