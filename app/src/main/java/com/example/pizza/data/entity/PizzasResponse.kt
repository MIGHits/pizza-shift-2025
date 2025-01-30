package com.example.pizza.data.entity

data class PizzasResponse(
    val success:Boolean,
    val reason:String?,
    val catalog:List<Pizza>
)
