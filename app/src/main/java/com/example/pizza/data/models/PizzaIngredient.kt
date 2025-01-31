package com.example.pizza.data.models

import android.os.Parcelable
import com.example.pizza.domain.entity.Ingredient
import kotlinx.parcelize.Parcelize


@Parcelize
data class PizzaIngredient(
    val name: Ingredient.IngredientName,
    val cost: Number,
    val img: String
) : Parcelable