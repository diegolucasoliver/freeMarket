package com.dmlo.freemarket.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dmlo.freemarket.routing.Screen
import com.dmlo.freemarket.ui.components.CustomTopAppBar
import com.dmlo.freemarket.ui.theme.FreeMarketTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavController) {

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = { Text(text = "Free Market") },
                backgroundColor = MaterialTheme.colorScheme.secondary
            )
        }
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var item by remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = item,
                onValueChange = { item = it },
                label = { Text(text = "Digite aqui o que busca") },
                textStyle = TextStyle(color = Color.White),
                maxLines = 1,
                trailingIcon = {
                    IconButton(onClick = { navController.navigate(Screen.Results.withArgs(item)) }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Ícone de lupa"
                        )
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    FreeMarketTheme {
        SearchScreen(navController = rememberNavController())
    }
}