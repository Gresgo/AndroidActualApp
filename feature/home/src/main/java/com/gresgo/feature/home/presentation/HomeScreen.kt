package com.gresgo.feature.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gresgo.core_presentation.Content
import com.gresgo.core_presentation.Error
import com.gresgo.core_presentation.Loading
import com.gresgo.feature.home.presentation.view.GitRepoView

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    when (val reposState = viewModel.viewState.collectAsState().value.repos) {
        is Content -> {
            val repos = reposState.data
            val listState = rememberLazyListState()
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .clip(RoundedCornerShape(10.dp)),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                state = listState
            ) {
                val size = repos.size
                items(size) { index ->
                    GitRepoView(repos[index], viewModel::onRepoClick)
                    if (index < size - 1)
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                }
            }
        }
        is Error -> {
            Column {
                Text(text = "error: ${reposState.throwable}")
                Button(onClick = viewModel::onReload) {
                    Text(text = "Try again")
                }
            }
        }
        is Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }
    }
}