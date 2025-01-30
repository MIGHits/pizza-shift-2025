package com.example.pizza.data.repository

import com.example.pizza.data.mapper.CatalogMapper
import com.example.pizza.data.remote.Api
import com.example.pizza.domain.entity.PizzasCatalog
import com.example.pizza.domain.repository.PizzaRepository

class PizzaRepositoryImpl(private val pizzaApi: Api, private val mapper: CatalogMapper) :
    PizzaRepository {
    override suspend fun getCatalog(): PizzasCatalog {
        return mapper.map(pizzaApi.getPizzasCatalog())
    }
}