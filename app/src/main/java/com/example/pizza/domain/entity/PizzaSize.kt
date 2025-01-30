package com.example.pizza.domain.entity

data class PizzaSize(
    val name:Size,
    val price:Number
)
{
    enum class Size{
        SMALL,MEDIUM,LARGE
    }
}