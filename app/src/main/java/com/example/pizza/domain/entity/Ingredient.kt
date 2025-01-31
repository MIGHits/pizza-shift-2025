package com.example.pizza.domain.entity


data class Ingredient(
    val name: IngredientName,
    val cost: Number,
    val img: String
) {
    enum class IngredientName {
        PINEAPPLE,
        MOZZARELLA,
        PEPERONI,
        GREEN_PEPPER,
        MUSHROOMS,
        BASIL,
        CHEDDAR,
        PARMESAN,
        FETA,
        HAM,
        PICKLE,
        TOMATO,
        BACON,
        ONION,
        CHILE,
        SHRIMPS,
        CHICKEN_FILLET,
        MEATBALLS
    }
}