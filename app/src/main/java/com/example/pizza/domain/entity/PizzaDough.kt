package com.example.pizza.domain.entity

data class PizzaDough (
    val name:Dough,
    val price:Number
){
    enum class Dough{
        THIN,THICK
    }
}