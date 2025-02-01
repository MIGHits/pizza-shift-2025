package com.example.pizza.presentation.view

import com.example.pizza.App
import com.example.pizza.R

sealed class BottomNavigationItem(val title: String, val icon: Int, val route: String) {
    object pizzaScreen : BottomNavigationItem(
        App.instance.getString(R.string.pizza_navigation),
        R.drawable.pizza_icon,
        "PizzaScreen"
    )

    object orderScreen : BottomNavigationItem(
        App.instance.getString(R.string.orders_navigation),
        R.drawable.order_icon,
        "OrderScreen"
    )

    object cartScreen : BottomNavigationItem(
        App.instance.getString(R.string.cart_navigation),
        R.drawable.trash_icon,
        "CartScreen"
    )

    object profileScreen : BottomNavigationItem(
        App.instance.getString(R.string.profile_navigation),
        R.drawable.profile_icon,
        "ProfileScreen"
    )
}