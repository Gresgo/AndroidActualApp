package com.gresgo.feature.home.data.mapper

import com.gresgo.feature.home.data.model.GitRepoData
import com.gresgo.feature.home.data.model.GitRepoEntity

interface GitRepoLocalMapper {

    companion object {
        private const val SPLITTER = ":"
    }

    fun map(entity: GitRepoEntity): GitRepoData
    fun map(data: GitRepoData): GitRepoEntity

    class Base: GitRepoLocalMapper {
        override fun map(entity: GitRepoEntity): GitRepoData {
            return GitRepoData(
                id = entity.id,
                ownerId = entity.ownerId,
                name = entity.name,
                owner = entity.owner,
                description = entity.description,
                language = entity.language,
                starsCount = entity.starsCount,
                watchersCount = entity.watchersCount,
                topics = entity.topics.split(SPLITTER)
            )
        }
        override fun map(data: GitRepoData): GitRepoEntity {
            return GitRepoEntity(
                id = data.id,
                ownerId = data.ownerId,
                name = data.name,
                owner = data.owner,
                description = data.description,
                language = data.language,
                starsCount = data.starsCount,
                watchersCount = data.watchersCount,
                topics = data.topics.joinToString { item -> "$item$SPLITTER" }
            )
        }
    }
}