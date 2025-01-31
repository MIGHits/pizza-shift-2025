package com.example.pizza.domain.usecase

import com.example.pizza.domain.entity.PizzasCatalog
import com.example.pizza.domain.repository.PizzaRepository

class GetCatalogUseCase(val pizzaRepository: PizzaRepository) {
    suspend operator fun invoke(): Result<PizzasCatalog> {
        return pizzaRepository.getCatalog()
    }
}