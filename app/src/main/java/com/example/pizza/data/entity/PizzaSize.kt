package com.example.pizza.data.entity

data class PizzaSize(
    val name:Size,
    val price:Number
)
{
    enum class Size{
        SMALL,MEDIUM,LARGE
    }
}