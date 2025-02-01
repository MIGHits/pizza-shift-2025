package com.example.pizza.di

import com.example.pizza.data.local.CartDatabase
import com.example.pizza.data.mapper.CartMapper
import com.example.pizza.data.mapper.CatalogMapper
import com.example.pizza.data.mapper.IngredientMapper
import com.example.pizza.data.mapper.PizzaMapper
import com.example.pizza.data.repository.CartRepositoryImpl
import com.example.pizza.data.repository.PizzaRepositoryImpl
import com.example.pizza.domain.repository.CartRepository
import com.example.pizza.domain.repository.PizzaRepository
import org.koin.dsl.module

val dataModule = module {
    single { CartDatabase.getDatabase() }

    single { get<CartDatabase>().cartDao() }

    factory<CatalogMapper> {
        CatalogMapper()
    }
    factory<PizzaMapper> {
        PizzaMapper()
    }

    factory<IngredientMapper> {
        IngredientMapper()
    }

    factory<CartMapper> {
        CartMapper()
    }

    single<CartRepository> { CartRepositoryImpl(cartDao = get(), cartMapper = get()) }

    single<PizzaRepository> {
        PizzaRepositoryImpl(
            pizzaApi = get(),
            mapper = get(),
            pizzaMapper = get(),
            ingredientMapper = get()
        )
    }
}