package com.gresgo.aaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import com.gresgo.aaa.ui.themes.MainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme(darkTheme = true) {
                Column(modifier = Modifier.fillMaxSize()) {
                    TopAppBar(title = {
                        Text(text = "Compose App")
                    })
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Hello Android!")
                    }
                }
            }
        }
    }
}