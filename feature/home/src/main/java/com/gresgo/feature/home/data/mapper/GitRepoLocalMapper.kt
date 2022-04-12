package com.gresgo.feature.home.data.mapper

import com.gresgo.feature.home.data.model.GitRepoData
import com.gresgo.feature.home.data.model.GitRepoLocal

interface GitRepoLocalMapper {

    fun map(local: GitRepoLocal): GitRepoData
    fun map(data: GitRepoData): GitRepoLocal

    class Base: GitRepoLocalMapper {
        override fun map(local: GitRepoLocal): GitRepoData {
            return GitRepoData(
                id = local.id,
                ownerId = local.ownerId,
                name = local.name,
                owner = local.owner,
                description = local.description,
                language = local.language,
                starsCount = local.starsCount,
                watchersCount = local.watchersCount,
                topics = local.topics
            )
        }
        override fun map(data: GitRepoData): GitRepoLocal {
            return GitRepoLocal(
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
    }
}