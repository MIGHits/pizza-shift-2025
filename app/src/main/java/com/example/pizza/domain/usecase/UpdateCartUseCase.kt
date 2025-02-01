package com.example.pizza.domain.usecase

import com.example.pizza.data.local.dbEntity.CartItemEntity
import com.example.pizza.domain.entity.CartItem
import com.example.pizza.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class UpdateCartUseCase(private val repository: CartRepository) {
    suspend operator fun invoke(cartItem: CartItem) {
        repository.updateCart(cartItem)
    }
}