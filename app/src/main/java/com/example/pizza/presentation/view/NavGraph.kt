package com.example.pizza.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizza.presentation.viewModel.PizzaViewModel

@Composable
fun NavGraph(navController: NavHostController, pizzaViewModel: PizzaViewModel) {
    NavHost(navController = navController, startDestination = "PizzaScreen") {
        composable("PizzaScreen") {
            PizzasScreen(pizzaViewModel, navController)
        }
        composable("OrderScreen") {
            OrderScreen()
        }
        composable("CartScreen") {
            CartScreen(pizzaViewModel,navController)
        }
        composable("ProfileScreen") {
            ProfileScreen()
        }
        composable(
            route = "PizzaDetails/{pizzaJson}",
            arguments = listOf(navArgument("pizzaJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val pizzaJson = backStackEntry.arguments?.getString("pizzaJson")
            PizzaDetails(navController, pizzaJson,pizzaViewModel)
        }
    }
}