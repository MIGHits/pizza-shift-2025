package com.example.pizza.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pizza.presentation.viewModel.PizzaViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PizzaViewModel> {
        PizzaViewModel(
            getCatalogUseCase = get(),
            getCartUseCase = get(),
            addToCartUseCase = get(),
            removeFromCartUseCase = get(),
            updateCartUseCase = get()
        )
    }
}