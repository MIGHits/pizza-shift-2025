package com.example.pizza.data.mapper

import com.example.pizza.common.URL.BASE_URL
import com.example.pizza.data.models.PizzaIngredient
import com.example.pizza.data.models.PizzaModel
import com.example.pizza.domain.entity.PizzaDough
import com.example.pizza.domain.entity.PizzaEntity
import com.example.pizza.domain.entity.PizzaSize

class PizzaMapper {
    fun map(pizza: PizzaModel, ingredientsMapper: IngredientMapper): PizzaEntity {
        return PizzaEntity(
            id = pizza.id,
            name = pizza.name,
            ingredients = ingredientsMapper.map(pizza.ingredients),
            toppings = ingredientsMapper.map(pizza.toppings),
            description = pizza.description,
            sizes = pizza.sizes,
            doughs = pizza.doughs,
            calories = pizza.calories,
            protein = pizza.protein,
            totalFat = pizza.totalFat,
            carbohydrates = pizza.carbohydrates,
            sodium = pizza.carbohydrates,
            allergens = pizza.allergens,
            isVegetarian = pizza.isVegetarian,
            isGlutenFree = pizza.isGlutenFree,
            isNew = pizza.isNew,
            isHit = pizza.isHit,
            img = BASE_URL + pizza.img

        )
    }

    fun map(pizzaList: List<PizzaModel>, ingredientsMapper: IngredientMapper): List<PizzaEntity> {
        return pizzaList.map { map(it, ingredientsMapper) }
    }
}