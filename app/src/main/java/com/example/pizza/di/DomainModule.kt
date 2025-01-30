package com.example.pizza.di

import com.example.pizza.data.repository.PizzaRepositoryImpl
import com.example.pizza.domain.repository.PizzaRepository
import com.example.pizza.domain.usecase.GetCatalogUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCatalogUseCase> {
        GetCatalogUseCase(pizzaRepository = get())
    }
}