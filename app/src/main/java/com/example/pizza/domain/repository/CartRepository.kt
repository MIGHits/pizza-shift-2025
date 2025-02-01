package com.example.pizza.domain.repository

import com.example.pizza.domain.entity.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun addToCart(cartItem: CartItem)
    suspend fun removeFromCart(cartItem: CartItem)
    suspend fun updateCart(cartItem: CartItem)
    suspend fun getCart(): Flow<List<CartItem>>
}