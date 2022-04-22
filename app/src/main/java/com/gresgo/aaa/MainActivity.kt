package com.gresgo.aaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.gresgo.aaa.ui.themes.MainTheme
import com.gresgo.core_navigation.Screens
import com.gresgo.core_navigation.composableScreen
import com.gresgo.feature.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val router: AppRouter
        get() = (application as App).router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme(darkTheme = true) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TopAppBar(title = {
                            Text(text = "Compose App")
                        })
                        NavigationHost()
                    }
                }
            }
        }
    }

    @Composable
    private fun NavigationHost() {
        val navController = rememberNavController()
        router.init(navController)
        NavHost(navController = navController, startDestination = Screens.Home.name) {
            composableScreen(Screens.Home) {
                HomeScreen(hiltViewModel())
            }
        }
    }
}