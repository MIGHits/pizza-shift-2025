package com.example.pizza.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.pizza.data.entity.Pizza
import com.example.pizza.presentation.viewModel.PizzaViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationScreen(pizzaViewModel: PizzaViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        modifier = Modifier.systemBarsPadding()
    ) {
        NavGraph(navController = navController, pizzaViewModel = pizzaViewModel)
    }
}