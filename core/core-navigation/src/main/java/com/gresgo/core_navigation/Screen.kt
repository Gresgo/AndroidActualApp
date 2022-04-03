package com.gresgo.core_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

data class Screen(
    val name: String,
    val args: List<NamedNavArgument> = emptyList()
)

fun NavGraphBuilder.composableScreen(
    screen: Screen,
    content: @Composable (NavBackStackEntry) -> Unit
): Unit = composable(
    route = screen.name,
    arguments = screen.args,
    content = content
)