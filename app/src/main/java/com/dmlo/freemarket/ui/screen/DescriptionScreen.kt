package com.dmlo.freemarket.ui.screen

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.dmlo.freemarket.ui.FreeMarketUiState
import com.dmlo.freemarket.ui.MainViewModel
import com.dmlo.freemarket.ui.components.CustomTopAppBar
import com.dmlo.freemarket.repository.model.ProductDescription
import com.dmlo.freemarket.ui.screen.description.DescriptionContent
import com.dmlo.freemarket.ui.screen.description.DescriptionError

@Composable
fun DescriptionScreen(
    navController: NavController,
    itemId: String,
    viewModel: MainViewModel
) {
    val uiState by viewModel.descriptionUiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchDescription(itemId)
    }

    DescriptionContentSetup(
        navController = navController,
        uiState = uiState
    ) { viewModel.fetchDescription(itemId) }
}

@Composable
fun DescriptionContentSetup(
    navController: NavController,
    uiState: FreeMarketUiState<ProductDescription>,
    retry: () -> Unit
) {
    Scaffold(
        modifier = Modifier.background(Color.LightGray),
        topBar = {
            CustomTopAppBar(
                title = { Text(text = "Descrição") },
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

        when (uiState) {
            is FreeMarketUiState.Success -> DescriptionContent(
                data = uiState.data,
                innerPadding = innerPadding
            )
            is FreeMarketUiState.Error -> DescriptionError(
                innerPadding = innerPadding,
                action = retry
            )
            else -> {}
        }
    }
}