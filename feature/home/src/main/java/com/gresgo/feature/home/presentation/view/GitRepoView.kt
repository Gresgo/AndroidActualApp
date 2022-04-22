package com.gresgo.feature.home.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gresgo.feature.home.presentation.model.GitRepo

@Composable
fun GitRepoView(
    gitRepo: GitRepo,
    onClick: (gitRepo: GitRepo) -> Unit
) {
    Column(Modifier.fillMaxWidth().clickable { onClick(gitRepo) }) {
        Text(
            text = gitRepo.name,
            maxLines = 1,
            color = Color.Magenta,
            fontSize = 18.sp
        )
        Text(
            text = gitRepo.description,
            maxLines = 1,
            color = Color.White,
            fontSize = 16.sp
        )
        Row {
            Text(text = "stars = ${gitRepo.stars}", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Language = ${gitRepo.language}", color = Color.Gray, fontSize = 14.sp)
        }
    }
}