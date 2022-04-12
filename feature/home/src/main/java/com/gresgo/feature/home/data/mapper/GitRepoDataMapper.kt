package com.gresgo.feature.home.data.mapper

import com.gresgo.feature.home.data.model.GitRepoData
import com.gresgo.feature.home.domain.GitRepoDomain

interface GitRepoDataMapper {

    fun map(data: GitRepoData): GitRepoDomain
    fun map(domain: GitRepoDomain): GitRepoData

    class Base: GitRepoDataMapper {
        override fun map(data: GitRepoData): GitRepoDomain {
            return GitRepoDomain(
                id = data.id,
                ownerId = data.ownerId,
                name = data.name,
                owner = data.owner,
                description = data.description,
                language = data.language,
                starsCount = data.starsCount,
                watchersCount = data.watchersCount,
                topics = data.topics
            )
        }
        override fun map(domain: GitRepoDomain): GitRepoData {
            return GitRepoData(
                id = domain.id,
                ownerId = domain.ownerId,
                name = domain.name,
                owner = domain.owner,
                description = domain.description,
                language = domain.language,
                starsCount = domain.starsCount,
                watchersCount = domain.watchersCount,
                topics = domain.topics
            )
        }
    }
}