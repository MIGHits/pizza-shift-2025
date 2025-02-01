package com.example.pizza.domain.entity

data class CartItem(
    val id: Int?,
    val pizza: PizzaEntity,
    var amount: Int,
    val toppings: List<Ingredient>,
    val selectedSize: PizzaSize.Size,
    val selectedDough: PizzaDough.Dough
)
