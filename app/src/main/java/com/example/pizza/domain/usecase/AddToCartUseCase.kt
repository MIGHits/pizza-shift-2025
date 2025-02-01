package com.example.pizza.domain.usecase

import com.example.pizza.data.local.dbEntity.CartItemEntity
import com.example.pizza.domain.entity.CartItem
import com.example.pizza.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class AddToCartUseCase(private val repository: CartRepository) {
    suspend operator fun invoke(cartItem: CartItem) {
        repository.addToCart(cartItem)
    }
}