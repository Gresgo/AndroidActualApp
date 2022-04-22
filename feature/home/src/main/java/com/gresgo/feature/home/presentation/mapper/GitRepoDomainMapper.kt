package com.gresgo.feature.home.presentation.mapper

import com.gresgo.feature.home.domain.GitRepoDomain
import com.gresgo.feature.home.presentation.model.GitRepo

interface GitRepoDomainMapper {

    fun map(domain: GitRepoDomain): GitRepo

    class Base: GitRepoDomainMapper {
        override fun map(domain: GitRepoDomain): GitRepo {
            return GitRepo(
                name = domain.name,
                description = domain.description,
                author = domain.owner,
                stars = domain.starsCount,
                language = domain.language)
        }
    }
}