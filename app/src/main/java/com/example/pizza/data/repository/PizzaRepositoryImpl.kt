package com.example.pizza.data.repository

import com.example.pizza.data.mapper.CatalogMapper
import com.example.pizza.data.mapper.IngredientMapper
import com.example.pizza.data.mapper.PizzaMapper
import com.example.pizza.data.remote.Api
import com.example.pizza.domain.entity.PizzasCatalog
import com.example.pizza.domain.repository.PizzaRepository
import com.example.pizza.exception.DomainException

class PizzaRepositoryImpl(
    private val pizzaApi: Api,
    private val mapper: CatalogMapper,
    private val pizzaMapper: PizzaMapper,
    private val ingredientMapper: IngredientMapper
) :
    PizzaRepository {
    override suspend fun getCatalog(): Result<PizzasCatalog> = runCatching {
        val response = pizzaApi.getPizzasCatalog()
        if (!response.success) {
            throw Exception("Failed to fetch catalog: ${response.reason ?: "Unknown error"}")
        }
        mapper.map(response, pizzaMapper, ingredientMapper)
    }.fold(
        onSuccess = { Result.success(it) },
        onFailure = { exception ->
            when (exception) {
                is DomainException -> Result.failure(exception)
                else -> Result.failure(DomainException("Unexpected error: ${exception.message}"))
            }
        })
}
