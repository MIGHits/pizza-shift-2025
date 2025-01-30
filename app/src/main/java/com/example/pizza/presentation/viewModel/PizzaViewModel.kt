package com.example.pizza.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizza.data.entity.Pizza
import com.example.pizza.domain.entity.PizzasCatalog
import com.example.pizza.domain.usecase.GetCatalogUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PizzaViewModel(private val getCatalogUseCase: GetCatalogUseCase) : ViewModel() {
    private val _catalog = MutableStateFlow<PizzasCatalog?>(null)
    val catalog: StateFlow<PizzasCatalog?> get() = _catalog

    fun getPizzasCatalog() = viewModelScope.launch {
        _catalog.value = getCatalogUseCase()
    }

}