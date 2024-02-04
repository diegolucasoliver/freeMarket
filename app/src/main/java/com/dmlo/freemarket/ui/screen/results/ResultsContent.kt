package com.dmlo.freemarket.ui.screen.results

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dmlo.freemarket.routing.Screen
import com.dmlo.freemarket.ui.components.ProductCard
import com.dmlo.freemarket.ui.model.Search

@Composable
fun ResultsContent(navController: NavController, data: Search, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        data.results.forEach { product ->
            ProductCard(product = product) {
                navController.navigate(Screen.Description.withArgs(product.id))
            }
        }
    }
}