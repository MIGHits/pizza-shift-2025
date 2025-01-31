package com.example.pizza.data.mapper

import com.example.pizza.common.URL.BASE_URL
import com.example.pizza.data.models.PizzaIngredient
import com.example.pizza.domain.entity.Ingredient

class IngredientMapper {
    private fun map(ingredient: PizzaIngredient): Ingredient {
        return Ingredient(
            name = ingredient.name,
            cost = ingredient.cost,
            img = BASE_URL + ingredient.img
        )
    }

    fun map(ingredients: List<PizzaIngredient>): List<Ingredient> {
        return ingredients.map { map(it) }
    }
}