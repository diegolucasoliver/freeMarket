package com.dmlo.freemarket.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dmlo.freemarket.routing.Navigation
import com.dmlo.freemarket.ui.theme.FreeMarketTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeMarketTheme {
                Navigation(viewModel = viewModel)
            }
        }
    }
}