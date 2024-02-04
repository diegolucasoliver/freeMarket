package com.dmlo.freemarket.routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dmlo.freemarket.ui.MainViewModel
import com.dmlo.freemarket.ui.screen.DescriptionScreen
import com.dmlo.freemarket.ui.screen.ResultsScreen
import com.dmlo.freemarket.ui.screen.SearchScreen

private const val QUERY = "query"
private const val PRODUCT_ID = "product_id"

sealed class Screen(val route: String) {
    data object Search : Screen("search_screen")
    data object Results : Screen("results_screen")
    data object Description : Screen("description_screen")

    fun withArgs(arg: String): String {
        return buildString {
            append(route)
            append("/$arg")
        }
    }
}

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Search.route) {

        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(
            route = Screen.Results.route + "/{$QUERY}",
            arguments = listOf(
                navArgument(QUERY) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val query = entry.arguments?.getString(QUERY).orEmpty()

            ResultsScreen(
                navController = navController,
                query = query,
                viewModel = viewModel
            )
        }

        composable(
            route = Screen.Description.route + "/{$PRODUCT_ID}",
            arguments = listOf(
                navArgument(PRODUCT_ID) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val productId = entry.arguments?.getString(PRODUCT_ID).orEmpty()

            DescriptionScreen(
                navController = navController,
                itemId = productId,
                viewModel = viewModel
            )
        }

    }
}