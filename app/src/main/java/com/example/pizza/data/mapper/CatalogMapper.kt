package com.example.pizza.data.mapper

import com.example.pizza.data.entity.PizzasResponse
import com.example.pizza.domain.entity.PizzasCatalog

class CatalogMapper {
    fun map(pizzas:PizzasResponse):PizzasCatalog{
        return PizzasCatalog(
            reason = pizzas.reason,
            success = pizzas.success,
            catalog = pizzas.catalog
        )
    }
}