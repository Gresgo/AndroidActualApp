package com.gresgo.feature.home.data.mapper

import com.gresgo.feature.home.data.model.GitRepoData
import com.gresgo.feature.home.data.model.GitRepoRemote

interface GitRepoRemoteMapper {

    fun map(remote: GitRepoRemote): GitRepoData

    class Base: GitRepoRemoteMapper {
        override fun map(remote: GitRepoRemote): GitRepoData {
            return GitRepoData(
                id = remote.id,
                ownerId = remote.owner.id,
                name = remote.name,
                owner = remote.owner.login,
                description = remote.description,
                language = remote.language,
                starsCount = remote.starsCount,
                watchersCount = remote.watchersCount,
                topics = remote.topics)
        }
    }
}