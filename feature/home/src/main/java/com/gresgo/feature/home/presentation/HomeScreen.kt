package com.gresgo.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(text = "Hello Android!")
            Button(onClick = viewModel::onClick) {
                Text(text = "Next screen")
            }
        }
    }
}
