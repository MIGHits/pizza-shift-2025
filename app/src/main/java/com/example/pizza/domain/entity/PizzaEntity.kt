package com.example.pizza.domain.entity


data class PizzaEntity(
    val id:String,
    val name:String,
    val ingredients:List<Ingredient>,
    val toppings:List<Ingredient>,
    val description:String,
    val sizes:List<PizzaSize>,
    val doughs:List<PizzaDough>,
    val calories:Number,
    val protein:String,
    val totalFat:String,
    val carbohydrates:String,
    val sodium:String,
    val allergens:List<String>,
    val isVegetarian:Boolean,
    val isGlutenFree:Boolean,
    val isNew:Boolean,
    val isHit:Boolean,
    val img:String
)