package com.dmlo.freemarket.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
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

    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        modifier = Modifier.background(Color.LightGray),
        topBar = {
            CustomTopAppBar(
                title = { Text(text = "Free Market") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var item by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = item,
                onValueChange = { item = it },
                label = { Text(text = "Digite aqui o que busca") },
                textStyle = TextStyle(color = Color.Black),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    navController.navigate(Screen.Results.withArgs(item))
                    keyboardController?.hide()
                }),
                trailingIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Results.withArgs(item))
                        keyboardController?.hide()
                    }) {
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