package com.example.pizza.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PizzaIngredient(
    val name: IngredientName,
    val cost: Number,
    val img: String
) : Parcelable {
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