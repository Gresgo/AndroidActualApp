package com.gresgo.aaa

import androidx.navigation.NavController
import com.gresgo.core_navigation.Router
import com.gresgo.core_navigation.Screen

class AppRouter: Router {

    private var navController: NavController? = null

    fun init(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(screen: Screen) {
        navController ?: error("NavController has not been initialized yet")
        navController?.navigate(screen.name)
    }

}