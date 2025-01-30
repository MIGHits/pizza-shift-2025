package com.example.pizza.domain.entity

import com.example.pizza.data.entity.Pizza

data class PizzasCatalog(
    val success:Boolean,
    val reason:String?,
    val catalog:List<Pizza>
)
