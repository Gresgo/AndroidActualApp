package com.gresgo.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gresgo.core.safeLaunch
import com.gresgo.core_navigation.Router
import com.gresgo.core_presentation.Content
import com.gresgo.core_presentation.Empty
import com.gresgo.core_presentation.Error
import com.gresgo.core_presentation.Loading
import com.gresgo.core_presentation.extension.update
import com.gresgo.feature.home.presentation.model.GitRepo
import com.gresgo.feature.home.domain.HomeInteractor
import com.gresgo.feature.home.domain.HomeResult
import com.gresgo.feature.home.presentation.mapper.GitRepoDomainMapper
import com.gresgo.feature.home.presentation.model.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val router: Router,
    private val homeInteractor: HomeInteractor,
    private val mapper: GitRepoDomainMapper
) : ViewModel() {

    // can be wrapped to class with single private field and 'observe' fun
    private val _viewState = MutableStateFlow(HomeViewState(repos = Loading()))
    val viewState = _viewState.asStateFlow()

    init {
        fetch()
    }

    private fun fetch(refresh: Boolean = false) {
        _viewState.update { copy(repos = Loading()) }
        viewModelScope.safeLaunch(
            block = {
                delay(3000)
                val result = homeInteractor.fetchGitRepos(refresh)
                handleResult(result)
            },
            onError = {
                _viewState.update { copy(repos = Error(it)) }
            }
        )
    }

    private fun handleResult(result: HomeResult) {
        when(result) {
            is HomeResult.Success -> {
                if (result.data.isNotEmpty()) {
                    _viewState.update {
                        copy(repos = Content(result.data.map { mapper.map(it) }))
                    }
                } else {
                    _viewState.update {
                        copy(repos = Empty())
                    }
                }
            }
            is HomeResult.Failure -> {
                if (result.data.isNotEmpty()) {
                    _viewState.update {
                        copy(repos = Content(result.data.map { mapper.map(it) }))
                    }
                    // TODO: show message to user
                } else {
                    _viewState.update { copy(repos = Error(result.error)) }
                }
            }
        }
    }

    fun onReload() = fetch(true)

    fun onRepoClick(repo: GitRepo) {
//        router.navigate(Screens.toDetails())
    }

}
