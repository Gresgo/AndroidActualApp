package com.gresgo.feature.home.presentation.model

import com.gresgo.core_presentation.State

data class HomeViewState(
    val repos: State<List<GitRepo>>
)