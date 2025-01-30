package com.example.pizza.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizza.presentation.viewModel.PizzaViewModel

@Composable
fun NavGraph(navController: NavHostController, pizzaViewModel: PizzaViewModel) {
    NavHost(navController = navController, startDestination = "PizzaScreen") {
        composable("PizzaScreen") {
            PizzasScreen(pizzaViewModel)
        }
        composable("OrderScreen") {
            OrderScreen()
        }
        composable("CartScreen") {
            CartScreen()
        }
        composable("ProfileScreen") {
            ProfileScreen()
        }
    }
}