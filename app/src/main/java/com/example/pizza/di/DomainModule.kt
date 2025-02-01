package com.example.pizza.di

import com.example.pizza.domain.usecase.AddToCartUseCase
import com.example.pizza.domain.usecase.GetCartUseCase
import com.example.pizza.domain.usecase.GetCatalogUseCase
import com.example.pizza.domain.usecase.RemoveFromCartUseCase
import com.example.pizza.domain.usecase.UpdateCartUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCatalogUseCase> { GetCatalogUseCase(pizzaRepository = get()) }
    factory<GetCartUseCase> { GetCartUseCase(repository = get()) }
    factory<AddToCartUseCase> { AddToCartUseCase(repository = get()) }
    factory<RemoveFromCartUseCase> { RemoveFromCartUseCase(repository = get()) }
    factory<UpdateCartUseCase> { UpdateCartUseCase(repository = get()) }
}