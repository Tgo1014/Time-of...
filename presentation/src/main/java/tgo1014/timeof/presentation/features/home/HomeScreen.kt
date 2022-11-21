package tgo1014.timeof.presentation.features.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import tgo1014.timeof.presentation.R
import tgo1014.timeof.presentation.models.WhateverPresentation
import tgo1014.timeof.presentation.ui.composables.DefaultPreview
import tgo1014.timeof.presentation.ui.theme.TimeOfTheme
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        whateverList = state.whateverList, onCreateWhatever = viewModel::createWhatever
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    whateverList: List<WhateverPresentation>,
    onCreateWhatever: (name: String, duration: Int) -> Unit = { _, _ -> },
) {
    val topAppBarScrollState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(topAppBarScrollState)
    var name by remember { mutableStateOf("") }
    var durationInt by remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = null,
                            modifier = Modifier.align(CenterVertically)
                        )
                        Spacer(Modifier.size(8.dp))
                        Text(
                            text = stringResource(R.string.app_name), fontWeight = FontWeight.Bold
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        content = {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
            ) {
                item {
                    OutlinedTextField(value = name,
                        onValueChange = { name = it },
                        label = { Text("_Name_") })
                }
                item {
                    OutlinedTextField(value = durationInt.toString(),
                        onValueChange = { durationInt = it.toIntOrNull() ?: 0 },
                        label = { Text("_Duration_") })
                }
//                item {
//                    OutlinedTextField(
//                        value = durationInt.toString(),
//                        onValueChange = { durationInt = it.toIntOrNull() ?: 0 },
//                        label = { Text("_Duration_") }
//                    )
//                }
                items(whateverList) { whatever ->
                    Text(text = whatever.toString())
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onCreateWhatever("FooBar", durationInt) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
    )
}

@Composable
@DefaultPreview
private fun HomeScreenPreview() = TimeOfTheme {
    HomeScreen(List(5) { WhateverPresentation(name = "teasdas", duration = 1.seconds) })
}