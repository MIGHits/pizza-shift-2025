package com.example.pizza.data.models

data class PizzasResponse(
    val success:Boolean,
    val reason:String?,
    val catalog:List<PizzaModel>
)
