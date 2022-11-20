package tgo1014.timeof.presentation.features.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import tgo1014.timeof.presentation.models.WhateverPresentation
import tgo1014.timeof.presentation.ui.theme.TimeOfTheme
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        whateverList = state.whateverList,
        onCreateWhatever = viewModel::createWhatever
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    whateverList: List<WhateverPresentation>,
    onCreateWhatever: (String) -> Unit = {},
) = Scaffold(
    topBar = {},
    content = {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(whateverList) { whatever ->
                Text(text = whatever.toString())
            }
        }
    },
    floatingActionButton = {
        FloatingActionButton(onClick = { onCreateWhatever("FooBar") }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    },
    modifier = Modifier.fillMaxSize()
)

@Composable
@Preview
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun HomeScreenPreview() = TimeOfTheme {
    HomeScreen(List(5) { WhateverPresentation("teasdas", 1.seconds) })
}