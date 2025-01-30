package com.example.pizza.data.entity

data class PizzaDough (
    val name:Dough,
    val price:Number
){
    enum class Dough{
        THIN,THICK
    }
}