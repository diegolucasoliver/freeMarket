package com.dmlo.freemarket.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dmlo.freemarket.ui.FreeMarketUiState
import com.dmlo.freemarket.ui.MainViewModel
import com.dmlo.freemarket.ui.components.CustomTopAppBar
import com.dmlo.freemarket.ui.model.Search
import com.dmlo.freemarket.ui.screen.results.ResultsContent
import com.dmlo.freemarket.ui.screen.results.ResultsError

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResultsScreen(
    navController: NavController,
    query: String,
    viewModel: MainViewModel
) {
    val uiState by viewModel.itemsUiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchItems(query)
    }

    ResultsContentSetup(
        query = query,
        navController = navController,
        uiState = uiState,
        search = { viewModel.fetchItems(it) },
        retry = { viewModel.fetchItems(query) }
    )
}

@Composable
fun ResultsContentSetup(
    query: String,
    navController: NavController,
    uiState: FreeMarketUiState<Search>,
    search: (String) -> Unit,
    retry: () -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        modifier = Modifier.background(Color.LightGray),
        topBar = {
            CustomTopAppBar(
                title = {
                    var item by rememberSaveable { mutableStateOf(query) }
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        value = item,
                        onValueChange = { item = it },
                        label = { Text(text = "Digite aqui o que busca") },
                        textStyle = TextStyle(color = Color.Black),
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            search(item)
                            keyboardController?.hide()
                        }),
                        trailingIcon = {
                            IconButton(onClick = {
                                search(item)
                                keyboardController?.hide()
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Ícone de lupa"
                                )
                            }
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Ícone de seta para esquerda"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        when(uiState) {
            is FreeMarketUiState.Success -> ResultsContent(
                innerPadding = innerPadding,
                navController = navController,
                data = uiState.data
            )
            is FreeMarketUiState.Error -> ResultsError(
                innerPadding = innerPadding,
                action = retry
            )
            else -> {}
        }
    }
}