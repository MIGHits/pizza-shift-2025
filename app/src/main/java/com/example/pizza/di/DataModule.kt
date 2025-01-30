package com.example.pizza.di

import com.example.pizza.data.mapper.CatalogMapper
import com.example.pizza.data.repository.PizzaRepositoryImpl
import com.example.pizza.domain.repository.PizzaRepository
import org.koin.dsl.module

val dataModule = module {
    single<CatalogMapper> {
        CatalogMapper()
    }
    single<PizzaRepository> {
        PizzaRepositoryImpl(pizzaApi = get(), mapper = get())
    }
}