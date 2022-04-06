package com.gresgo.feature.home.presentation

import androidx.lifecycle.ViewModel
import com.gresgo.core_navigation.Router
import com.gresgo.core_navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun onClick() {

    }

}
