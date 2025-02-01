package com.example.pizza.presentation.viewModel

import android.util.Log
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizza.App
import com.example.pizza.R
import com.example.pizza.data.local.dao.CartDao
import com.example.pizza.data.local.dbEntity.CartItemEntity
import com.example.pizza.data.mapper.CartMapper
import com.example.pizza.domain.entity.CartItem
import com.example.pizza.domain.entity.Ingredient
import com.example.pizza.domain.entity.PizzaDough
import com.example.pizza.domain.entity.PizzaEntity
import com.example.pizza.domain.entity.PizzaSize
import com.example.pizza.domain.entity.PizzasCatalog
import com.example.pizza.domain.usecase.AddToCartUseCase
import com.example.pizza.domain.usecase.GetCartUseCase
import com.example.pizza.domain.usecase.GetCatalogUseCase
import com.example.pizza.domain.usecase.RemoveFromCartUseCase
import com.example.pizza.domain.usecase.UpdateCartUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class PizzaViewModel(
    private val getCatalogUseCase: GetCatalogUseCase,
    private val getCartUseCase: GetCartUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase,
    private val updateCartUseCase: UpdateCartUseCase
) : ViewModel() {
    private val _catalog = MutableStateFlow<PizzasCatalog?>(null)
    val catalog: StateFlow<PizzasCatalog?> get() = _catalog

    private val _selectedToppings = MutableStateFlow<List<Ingredient>>(emptyList())
    val selectedToppings: StateFlow<List<Ingredient>> get() = _selectedToppings

    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart: StateFlow<List<CartItem>> get() = _cart

    private val _selectedSize = MutableStateFlow<PizzaSize.Size>(PizzaSize.Size.SMALL)
    val selectedSize: StateFlow<PizzaSize.Size> get() = _selectedSize

    private val _selectedDough = MutableStateFlow<PizzaDough.Dough>(PizzaDough.Dough.THIN)
    val selectedDough: StateFlow<PizzaDough.Dough> get() = _selectedDough

    init {
        getCart()
    }

    fun getPizzasCatalog() {
        viewModelScope.launch {
            _catalog.value = getCatalogUseCase().getOrNull()
        }
    }

    fun addTopping(topping: Ingredient) {
        _selectedToppings.value += (topping)
    }

    fun removeTopping(topping: Ingredient) {
        _selectedToppings.value -= (topping)
    }

    private fun getCart() {
        viewModelScope.launch { getCartUseCase().collect(_cart) }
    }

    fun addToCart(pizza: PizzaEntity) {
        viewModelScope.launch {
            val cartPizza = CartItem(
                null,
                pizza,
                1,
                _selectedToppings.value,
                _selectedSize.value,
                _selectedDough.value
            )
            addToCartUseCase(cartPizza)
            clearPizzaToppings()
        }
    }

    fun removeFromCart(cartItem: CartItem) {
        viewModelScope.launch {
            removeFromCartUseCase(cartItem)
        }
    }

    fun updateCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            updateCartUseCase(cartItem)
            if (cartItem.amount <= 0) {
                removeFromCart(cartItem)
            }
        }
    }

    fun updatePizzaDetails(cartItem: CartItem) {
        _selectedToppings.value = cartItem.toppings
    }

    fun clearPizzaToppings() {
        _selectedToppings.value = emptyList()
    }

    fun selectPizzaSize(pizzaSize: String) {
        when (pizzaSize) {
            getString(App.instance, R.string.small_size) -> _selectedSize.value =
                PizzaSize.Size.SMALL

            getString(App.instance, R.string.medium_size) -> _selectedSize.value =
                PizzaSize.Size.MEDIUM

            getString(App.instance, R.string.size_large) -> _selectedSize.value =
                PizzaSize.Size.LARGE
        }
    }
}