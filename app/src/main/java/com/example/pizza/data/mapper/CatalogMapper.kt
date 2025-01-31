package com.example.pizza.data.mapper

import com.example.pizza.data.models.PizzasResponse
import com.example.pizza.domain.entity.PizzasCatalog

class CatalogMapper {
    fun map(
        pizzas: PizzasResponse,
        pizzaMapper: PizzaMapper,
        ingredientMapper: IngredientMapper
    ): PizzasCatalog {
        return PizzasCatalog(
            catalog = pizzaMapper.map(pizzas.catalog, ingredientMapper)
        )
    }
}