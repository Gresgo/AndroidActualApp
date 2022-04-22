package com.gresgo.feature.home.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GitRepoEntity(
    @PrimaryKey
    val id: Int,
    val ownerId: Int,
    val name: String,
    val owner: String,
    val description: String,
    val language: String,
    val starsCount: Int,
    val watchersCount: Int,
    val topics: String
)