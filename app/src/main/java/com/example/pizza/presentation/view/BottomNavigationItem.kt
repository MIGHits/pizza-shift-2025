package com.example.pizza.presentation.view

import com.example.pizza.R

sealed class BottomNavigationItem(val title: String, val icon: Int, val route: String) {
    object pizzaScreen : BottomNavigationItem("Пицца", R.drawable.pizza_icon, "PizzaScreen")
    object orderScreen : BottomNavigationItem("Заказы", R.drawable.order_icon, "OrderScreen")
    object cartScreen : BottomNavigationItem("Корзина", R.drawable.trash_icon, "CartScreen")
    object profileScreen : BottomNavigationItem("Профиль", R.drawable.profile_icon, "ProfileScreen")
}